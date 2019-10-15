package com.example.MockHackathon.adapter;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.MockHackathon.model.Account;
import com.example.MockHackathon.model.AccountViews;
import com.example.MockHackathon.model.User;

@FeignClient(name="ObpApiClient", url="${obp.api.versionedUrl}")
public interface ObpApiClient {

    //tag::my-account[]
    @GetMapping(value = "my/accounts")
    List<Account> getPrivateAccountsNoDetails();

    @GetMapping(value = "my/banks/{bankId}/accounts/{accountId}/account")
    Account getAccount(@PathVariable("bankId") String bankId, @PathVariable("accountId") String accountId);

    @GetMapping(value = "banks/{bankId}/accounts/{accountId}/views")
    AccountViews getViewsForAccount(@PathVariable("bankId") String bankId, @PathVariable("accountId") String accountId);

    //tag::public-accounts[]
    @GetMapping(value = "accounts")
    List<Account> getAllPublicAccountsAtAllBanks();

    @PutMapping("/banks/{bankId}/accounts/{accountId}")
    Account createAccount(@PathVariable("bankId") String bankId, @PathVariable("accountId") String accountId, @RequestBody Account accountRequest);

    @GetMapping("users/current")
    User getCurrentUser();

}