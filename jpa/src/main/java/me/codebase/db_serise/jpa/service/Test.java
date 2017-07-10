package me.codebase.db_serise.jpa.service;

import me.codebase.db_serise.jpa.repository.ApplicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

/**
 * Created by chendong on 2017/7/10.
 */
@Service
public class Test {

    private final ApplicationRepository applicationRepository;

    @Autowired
    public Test(ApplicationRepository applicationRepository) {
        this.applicationRepository = applicationRepository;
    }

    @PostConstruct
    public void init() {
        System.out.println(applicationRepository.findByAppId("2222"));
    }

}
