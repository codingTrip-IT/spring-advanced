package org.example.expert.domain.user.enums;

import org.example.expert.domain.common.exception.InvalidRequestException;

import java.util.Arrays;

/**
 * UserRole : 사용자의 역할을 정의하는 enum 클래스
 */
public enum UserRole {
    ADMIN, USER;

    public static UserRole of(String role) {
        return Arrays.stream(UserRole.values())
                .filter(r -> r.name().equalsIgnoreCase(role))
                .findFirst()
                .orElseThrow(() -> new InvalidRequestException("유효하지 않은 UerRole"));
    }
}
