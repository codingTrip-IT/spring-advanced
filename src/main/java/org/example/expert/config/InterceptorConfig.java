package org.example.expert.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * InterceptorConfig : 인터셉터를 설정하는 구성 클래스
 * */
@Configuration
@RequiredArgsConstructor
public class InterceptorConfig implements WebMvcConfigurer {

    /**
     * 인터셉터를 등록하는 메서드
     * AdminCheckInterceptor를 "/admin/**" 경로에 대해 등록함
     * @param registry 인터셉터를 등록할 객체
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new AdminCheckInterceptor())
                .order(1)
                .addPathPatterns("/admin/**");
    }
}
