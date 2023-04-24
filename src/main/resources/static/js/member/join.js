    // 캘린더 생성
    $("#birth").datepicker();

    //회원가입 정규식
    function checkPw() {
        let id = $("#memberId").val();
        let pw = $("#password").val();
        let nm = $("#name").val();

        //아이디 검증
        if (id.length < 4 || id.length > 10) {
            alert("4자리 ~ 10자리 이내로 입력해주세요.");
            $("#memberId").focus();
            return false;
        } else if (pw.length < 4 || pw.length > 10) {
            alert("4자리 ~ 10자리 이내로 입력해주세요.");
            $("#password").focus();
            return false;
        } else if (pw.search(/\s/) != -1) {
            alert("비밀번호는 공백 없이 입력해주세요.");
            $("#password").focus();
            return false;
        } else if (nm.length = 0) {
            alert("이름은 필수 값 입니다.");
            $("#name").focus();
            return false;
        }
        return true;
    }



