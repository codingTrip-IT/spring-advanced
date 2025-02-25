package org.example.expert.config;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.expert.domain.user.enums.UserRole;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class AdminCheckInterceptor implements HandlerInterceptor {

    private final Logger log = LoggerFactory.getLogger(getClass());

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String requestURI = request.getRequestURI();
        log.info("인증 체크 인터셉터 실행 {}", requestURI);

        String userRole = (String) request.getAttribute("userRole");
        log.info("userRole = {}", userRole);

        if (!UserRole.ADMIN.name().equals(userRole)){
            log.error("미인증 사용자 요청");
            response.sendError(HttpServletResponse.SC_FORBIDDEN, "관리자 권한이 없습니다.");
            return false;
        }

        // 요청 시각과 URL을 로깅
        LocalDateTime now = LocalDateTime.now();
        String formatNow = now.format(DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss"));
        log.info("요청 시각 = {}, URL = {}", formatNow, requestURI);

        return true;
    }
}
