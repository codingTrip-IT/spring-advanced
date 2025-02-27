package org.example.expert.domain.auth.dto.response;

import lombok.Getter;
import org.example.expert.domain.user.enums.UserRole;

/**
 * SignupResponse : 회원가입 응답 DTO
 * 필드명 : 아이디, 이메일, 사용자권한
 * */
@Getter
public class SignupResponse {

    /** 수정 전
     * 회원 가입 후 즉시 JWT 발급
     * */
    /*
    private final String bearerToken;

    public SignupResponse(String bearerToken) {
        this.bearerToken = bearerToken;
    }
    */

    /** 수정 후
     * 회원 가입 후 ResponseBody에는 회원의 아이디, 이메일, 역할 정보만 보여주는 것으로 수정
     */
    private final Long id;
    private final String email;
    private final UserRole userRole;

    public SignupResponse(Long id, String email, UserRole userRole) {
        this.id = id;
        this.email = email;
        this.userRole = userRole;
    }
}
