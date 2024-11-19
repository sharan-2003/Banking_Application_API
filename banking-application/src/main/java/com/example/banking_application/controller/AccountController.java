package com.example.banking_application.controller;

import com.example.banking_application.DTO.AccountDTO;
import com.example.banking_application.entity.Account;
import com.example.banking_application.service.AccountService;
import org.hibernate.cache.spi.support.StorageAccess;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {

    private AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    //Add Account REST API
    @PostMapping
    public ResponseEntity<AccountDTO> addAccount(@RequestBody AccountDTO accountDTO){
        return new ResponseEntity<>(accountService.createAccount(accountDTO), HttpStatus.CREATED);
    }

    //Get All Accounts



    //Get Account GET REST API
    @GetMapping("/{id}")

    public ResponseEntity<AccountDTO> getAccountById(@PathVariable Long id){
        AccountDTO accountDTO = accountService.getAccountById(id);
        return ResponseEntity.ok(accountDTO);
    }

    //Deposit REST API
    @PutMapping("/{id}/deposit")
    public ResponseEntity<AccountDTO> depositAmount(@PathVariable Long id,@RequestBody Map<String, Double> request){

        Double amount = request.get("amount");
        AccountDTO accountDTO = accountService.depositAmount(id, amount);
        return ResponseEntity.ok(accountDTO);
    }

    //Withdraw REST API
    @PutMapping("/{id}/withdraw")
    public ResponseEntity<AccountDTO> withdrawAmount(@PathVariable Long id,@RequestBody Map<String, Double> request){
        double amount = request.get("amount");
        AccountDTO accountDTO = accountService.withdrawAmount(id, amount);
        return ResponseEntity.ok(accountDTO);
    }

    //Get All Accounts REST API
    @GetMapping
    public ResponseEntity<List<AccountDTO>> getAllAccounts(){
        List<AccountDTO> accounts = accountService.getAllAccounts();
        return ResponseEntity.ok(accounts);
    }

    //Delete REST API
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAccount(@PathVariable Long id){
        accountService.deleteAccount(id);
        return ResponseEntity.ok("Account is deleted Successfully");
    }
}
