//package com.example.sunbase.sunbase.security;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import jakarta.servlet.ServletException;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import org.springframework.http.HttpStatus;
//import org.springframework.security.core.AuthenticationException;
//import org.springframework.security.web.AuthenticationEntryPoint;
//import org.springframework.stereotype.Component;
//
//import java.io.IOException;
//import java.io.OutputStream;
//import java.util.HashMap;
//import java.util.Map;
//
//@Component
//public abstract class JwtAuthenticationEntryPoint implements AuthenticationEntryPoint {
//
//    public void commence(HttpServletRequest request,
//                         HttpServletResponse response,
//                         AuthenticationException authException) throws IOException {
//
//        // Customize the error response here
//        response.setStatus(HttpStatus.UNAUTHORIZED.value());
//        response.setContentType("application/json");
//
//        Map<String, Object> errorResponse = new HashMap<>();
//        errorResponse.put("status", HttpStatus.UNAUTHORIZED.value());
//        errorResponse.put("error", "Unauthorized");
//        errorResponse.put("message", "Authentication failed: " + authException.getMessage());
//
//        ObjectMapper objectMapper = new ObjectMapper();
//        String json = objectMapper.writeValueAsString(errorResponse);
//
//        OutputStream out = response.getOutputStream();
//        out.write(json.getBytes());
//        out.flush();
//    }
//
//}