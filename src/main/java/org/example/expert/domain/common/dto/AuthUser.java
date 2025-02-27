package org.example.expert.domain.common.dto;

import lombok.Getter;
import org.example.expert.domain.user.enums.UserRole;

/**
 * AuthUser : 인증된 사용자의 정보를 담는 DTO
 * 필드명 : 아이디, 이메일, 사용자권한
 */
@Getter
public class AuthUser {

    private final Long id;
    private final String email;
    private final UserRole userRole;

    public AuthUser(Long id, String email, UserRole userRole) {
        this.id = id;
        this.email = email;
        this.userRole = userRole;
    }
}
