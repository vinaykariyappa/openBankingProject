package com.example.MockHackathon.adapter;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import feign.RequestInterceptor;
import feign.RequestTemplate;

@Component
public class AddAuthRequestInterceptor implements RequestInterceptor {
    
	private String directLoginPath;

    @Autowired
	private HashMap<String,String> map;
    
    public AddAuthRequestInterceptor(@Value("${obp.api.directLoginPath}") String directLoginPath) {
        this.directLoginPath = directLoginPath;
    }

    @Override
    public void apply(RequestTemplate template) {
        //skip login request, no auth context to add.
        if(directLoginPath.equals(template.url())) {
            return;
        }
        
        String dlHeader = String.format("DirectLogin token=%s", map.get("TOKEN"));
        template.header(HttpHeaders.AUTHORIZATION, dlHeader);
    }
}