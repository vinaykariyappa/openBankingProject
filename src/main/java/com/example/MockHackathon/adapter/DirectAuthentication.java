package com.example.MockHackathon.adapter;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;

import com.example.MockHackathon.model.Token;

@FeignClient(name="directAuthentication", url="${obp.api.rootUrl}")
public interface DirectAuthentication {

    @PostMapping(value = "${obp.api.directLoginPath}")
    Token loginInternal(@RequestHeader("Authorization") String authHeader);

    default String login(String username, String password, String consumerKey) {
        String dlData = String.format("DirectLogin username=%s,password=%s,consumer_key=%s", username, password, consumerKey);
        String token = loginInternal(dlData).getToken();
        System.out.println("TOKEN>>>>>>>>>>>>>"+token);
        return token;
    }
}