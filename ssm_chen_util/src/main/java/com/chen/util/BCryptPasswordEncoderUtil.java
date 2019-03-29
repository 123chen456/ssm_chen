package com.chen.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class BCryptPasswordEncoderUtil {

    public static String encodePassword(String password){
        BCryptPasswordEncoder bCryptPasswordEncoder=new BCryptPasswordEncoder();
        String encode = bCryptPasswordEncoder.encode(password);
        boolean matches = bCryptPasswordEncoder.matches("huaer", "$2a$10$vySJ9ST3EKcaGiqtB9m9FuFpiZPBlmu.0RUde6deS04fbGEayVwOi");
        System.out.println(matches);
        return encode;
    }

    public static void main(String[] args) {
        String s = encodePassword("huaer");
        System.out.println(s);
    }
}
