function checkDuplicateId(userId) {
    const data = JSON.stringify({ userId: userId });

    const options = {
        method: "POST",
        headers: {
            "Content-type": "application/json"
        },
        body: data
    };

    return new Promise((resolve, reject) => {
        fetch("/idCheck", options) // 서버의 실제 엔드포인트로 수정
            .then(response => {
                if (!response.ok) {
                    throw new Error(`HTTP error! Status: ${response.status}`);
                }
                return response.json();
            })
            .then(data => {
                // 서버로부터 받은 응답 처리
                resolve(data);
            })
            .catch(error => {
                // 오류 발생 시 처리
                reject(error);
            });
    });
}

// 예시로 버튼 클릭 시 ID 중복 검사 함수 호출
function clickHandler() {
    const userIdValue = userId.value; // userId는 어떻게 얻어오는지에 대한 코드가 없어 가정

    checkDuplicateId(userIdValue)
        .then(responseData => {
            // 서버로부터 받은 응답에 따른 처리
            console.log(responseData);
        })
        .catch(error => {
            // 오류 발생 시 처리
            console.error(error);
        });
}
