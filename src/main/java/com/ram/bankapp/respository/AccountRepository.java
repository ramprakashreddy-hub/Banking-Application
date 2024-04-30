package com.ram.bankapp.respository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ram.bankapp.Entity.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long>{
 
}
