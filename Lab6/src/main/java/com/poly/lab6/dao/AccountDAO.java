package com.poly.lab6_1.dao;

import com.poly.lab6_1.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountDAO extends JpaRepository<Account, String> {
}
