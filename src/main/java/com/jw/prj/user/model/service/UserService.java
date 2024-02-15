package com.jw.prj.user.model.service;

import com.jw.prj.common.util.SHA256;
import com.jw.prj.user.model.dao.UserMapper;
import com.jw.prj.user.model.vo.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Slf4j
@Service
@Transactional
public class UserService {
    private final UserMapper userMapper;

    public int insertUser(User user, String joinedAddress) {
        String salt = SHA256.generateSalt();
        String hashedPw = SHA256.getEncrypt(user.getUserPw(), salt);

        User insertUser = User.builder()
                .userId(user.getUserId())
                .userPw(hashedPw)
                .userName(user.getUserName())
                .userNickname(user.getUserNickname())
                .userAddress(joinedAddress)
                .userGender(user.getUserGender())
                .userPhone(user.getUserPhone())
                .userEmail(user.getUserEmail())
                .salt(salt).build();

        log.info("hashedPw::::{}", hashedPw);
        return userMapper.insertUser(insertUser);
    }

}
