package org.example.expert.domain.user.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * UserChangePasswordRequest : 사용자 비밀번호 수정 요청 DTO
 * 필드명 : 수정 전 비밀번호, 수정 후 비밀번호
 */
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UserChangePasswordRequest {

    @NotBlank
    private String oldPassword;
    @NotBlank
    @Pattern(regexp = "(?=.*[A-Z])(?=.*\\d)[A-Za-z\\d$@$!%*?&]{8,}", message = "새 비밀번호는 8자 이상이어야 하고, 숫자와 대문자를 포함해야 합니다.")
    private String newPassword;
}
