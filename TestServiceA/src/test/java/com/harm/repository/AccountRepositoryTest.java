package com.harm.repository;

import com.harm.entity.Account;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;

import java.time.LocalDateTime;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AccountRepositoryTest {
    Logger logger = LoggerFactory.getLogger(AccountRepositoryTest.class);
    @Autowired
    AccountRepository accountRepository;

    @Transactional
    @Test
    @Rollback(false)
    public void initTest() {
        Account newAccount = new Account();
        newAccount.setName("herdin" + LocalDateTime.now());
        newAccount.setEmail("herdin" + LocalDateTime.now() + "@gmail.com");
        newAccount.setAge(LocalDateTime.now().getSecond());

        Account savedAccount = accountRepository.save(newAccount);
        logger.debug("save account -> {}", savedAccount);
    }
}