package com.harm.runner;

import com.harm.entity.Account;
import com.harm.repository.AccountRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class MariaRunner implements ApplicationRunner {
    Logger logger = LoggerFactory.getLogger(MariaRunner.class);
    @Override
    public void run(ApplicationArguments args) throws Exception {
        logger.debug("hello");
//        Account newAccount = new Account();
//        newAccount.setName("herdin" + LocalDateTime.now());
//        newAccount.setEmail("herdin" + LocalDateTime.now() + "@gmail.com");
//        newAccount.setAge(LocalDateTime.now().getSecond());
//
//        accountRepository.save(newAccount);
    }
}
