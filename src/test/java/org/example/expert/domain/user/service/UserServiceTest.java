package org.example.expert.domain.user.service;

import org.example.expert.domain.common.exception.InvalidRequestException;
import org.example.expert.domain.user.dto.response.UserResponse;
import org.example.expert.domain.user.entity.User;
import org.example.expert.domain.user.enums.UserRole;
import org.example.expert.domain.user.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.util.ReflectionTestUtils;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    @Test
    void User를_ID로_조회할_수_있다(){
        //given
        String email = "study@naver.com";
        long userId = 1L;
        User user = new User(email,"password", UserRole.USER);
        ReflectionTestUtils.setField(user,"id",userId);

        given(userRepository.findById(anyLong())).willReturn(Optional.of(user));

        //when
        UserResponse userResponse = userService.getUser(userId);

        //then
        assertNotNull(userResponse);
        assertEquals(userId, userResponse.getId());
        assertEquals(email, userResponse.getEmail());
    }

    @Test
    void 존재하지_않는_User를_조회_시_InvalidRequestException을_던진다(){
        //given
        long userId = 1L;
        given(userRepository.findById(anyLong())).willReturn(Optional.empty());

        //when & then
        assertThrows(InvalidRequestException.class,
                () -> userService.getUser(userId),
                "User not found");
    }

}