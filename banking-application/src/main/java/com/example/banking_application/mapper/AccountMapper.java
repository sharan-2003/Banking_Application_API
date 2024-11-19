package com.example.banking_application.mapper;

import com.example.banking_application.DTO.AccountDTO;
import com.example.banking_application.entity.Account;

public class AccountMapper {

    //DTO to Entity
    public static Account mapToAccount(AccountDTO accountDTO){
        Account account = new Account(
                accountDTO.getId(),
                accountDTO.getAccountHolderName(),
                accountDTO.getBalance()
        );
        return account;
    }

    //Entity to DTO
    public static AccountDTO mapToAccountDTO(Account account){
        AccountDTO accountDTO = new AccountDTO(
                account.getId(),
                account.getAccountHolderName(),
                account.getBalance()

        );
        return accountDTO;
    }
}
