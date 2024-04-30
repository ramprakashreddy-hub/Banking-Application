package com.ram.bankapp.service;

import java.util.List;

import com.ram.bankapp.dto.AccountDto;

public interface AccountService {
	
	
	AccountDto createAccount(AccountDto accountDto);

	AccountDto getAccountById(Long id);
	
	AccountDto deposite(Long id, double ammount);
	
	AccountDto withdraw(Long id, double amount);
	
	List<AccountDto> getAllAccounts();
	
	void deleteById(Long id);
	
}
