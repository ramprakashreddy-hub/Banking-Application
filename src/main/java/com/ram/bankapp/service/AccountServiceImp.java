package com.ram.bankapp.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.ram.bankapp.Entity.Account;
import com.ram.bankapp.dto.AccountDto;
import com.ram.bankapp.mapper.AccountMapper;
import com.ram.bankapp.respository.AccountRepository;

@Service
public class AccountServiceImp implements AccountService {
	
	
	private AccountRepository accountRepository;
	
	
	
	

	public AccountServiceImp(AccountRepository accountRepository) {
		this.accountRepository = accountRepository;
	}



	@Override
	public AccountDto createAccount(AccountDto accountDto) {
	              Account account=AccountMapper.mapToAccount(accountDto);
	              Account save1 = accountRepository.save(account);
	              return AccountMapper.mapToAccountDto(save1);
		
		}



	@Override
	public AccountDto getAccountById(Long id) {
		Account account = accountRepository.findById(id).orElseThrow(() 
				-> new RuntimeException("account does not exist"));
		
		return AccountMapper.mapToAccountDto(account);
	}



	@Override
	public AccountDto deposite(Long id, double amount) {
		
		Account account = accountRepository.findById(id).orElseThrow(() 
				-> new RuntimeException("account does not exist"));
		
		double total =account.getBalance()+amount;
		account.setBalance(total);
		
		return AccountMapper.mapToAccountDto(accountRepository.save(account));
	}



	@Override
	public AccountDto withdraw(Long id, double amount) {
		
		Account account = accountRepository.findById(id).orElseThrow(()
				-> new RuntimeException("account does not exist"));
		
		if(account.getBalance()<amount) {
			throw new RuntimeException("Insufficient balance");
		}
		
		double total =account.getBalance()-amount;
		account.setBalance(total);
		
		return AccountMapper.mapToAccountDto(accountRepository.save(account));
		
	}



	@Override
	public List<AccountDto> getAllAccounts() {
		
	List<Account> findAll = accountRepository.findAll();
	
	List<AccountDto> collect = findAll.stream().map(
			(accounts)->AccountMapper.mapToAccountDto(accounts)).collect(Collectors.toList());
	
	return collect;
	}



	@Override
	public void deleteById(Long id) {
		Account account = accountRepository.findById(id).orElseThrow(()
				-> new RuntimeException("account does not exist"));
		
		accountRepository.deleteById(id);
		
	}




}
