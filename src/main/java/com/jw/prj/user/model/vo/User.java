package com.jw.prj.user.model.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.apache.ibatis.type.Alias;

@Builder
@Getter
@Setter
@Alias("User")
public class User {
    private Long userNo;
    private String userId;
    private String userPw;
    private String userEmail;
    private String userName;
    private String userNickname;
    private String userPhone;
    private String userGender;
    private String userAddress;
    private String socialType;
    private String salt;
    private String withdrawalFlag;

}
