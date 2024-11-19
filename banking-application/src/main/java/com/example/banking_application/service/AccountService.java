package com.example.banking_application.service;

import com.example.banking_application.DTO.AccountDTO;
import com.example.banking_application.entity.Account;

import java.util.*;


public interface AccountService {

    AccountDTO createAccount(AccountDTO accountDTO);

    AccountDTO getAccountById(Long id);

    AccountDTO depositAmount(Long id, double amount);

    AccountDTO withdrawAmount(Long id, double amount);

    List<AccountDTO> getAllAccounts();

    void deleteAccount(Long id);

}
