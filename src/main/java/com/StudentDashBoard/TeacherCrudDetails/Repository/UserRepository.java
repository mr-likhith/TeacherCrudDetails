package com.StudentDashBoard.TeacherCrudDetails.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.StudentDashBoard.TeacherCrudDetails.model.UserModel;

@Repository
public interface UserRepository extends JpaRepository<UserModel, Long> {
	Optional<UserModel>findByLoginAndPassword(String login,String password);
}
//package com.StudentDashBoard.TeacherCrudDetails.StdConfig;
//
//import java.io.IOException;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.web.SecurityFilterChain;
//import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
//
//import jakarta.servlet.ServletException;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//
//@Configuration
//@EnableWebSecurity
//public class SecurityConfig {
//	@SuppressWarnings("deprecation")
//	@Bean
//  public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//      http
//          .authorizeRequests()
//              .anyRequest().authenticated()
//              .and()
//          .oauth2Login(oauth2Login ->
//              oauth2Login
//                  .loginProcessingUrl("/login")
//                  .loginPage("/oauth2/authorization/google")
//                  .successHandler(new AuthenticationSuccessHandler() {
//                      @Override
//                      public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
//                                                          Authentication authentication) throws IOException, ServletException {
//                          request.authenticate(response);
//                      }
//                  })
//          );
//      return http.build();
//  }
//}