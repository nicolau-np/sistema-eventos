package com.eventos.eventos.Services;

import org.springframework.stereotype.Service;

import jakarta.servlet.http.HttpSession;

@Service
public class AuthService {

    public Boolean getData(HttpSession session) {
        if (session != null && session.getAttribute("email") != null) {
            return true;
        } else {
            return false;
        }

    }
}
