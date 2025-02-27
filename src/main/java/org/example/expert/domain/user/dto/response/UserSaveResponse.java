package org.example.expert.domain.user.dto.response;

import lombok.Getter;

/**
 * 현재 사용하고 있지 않음 - 회원가입 시 JWT 발급하지 않도록 수정함
 * UserSaveResponse : 사용자 생성 응답 DTO
 * 필드명 : 토큰
 */
@Getter
public class UserSaveResponse {

    private final String bearerToken;

    public UserSaveResponse(String bearerToken) {
        this.bearerToken = bearerToken;
    }
}
