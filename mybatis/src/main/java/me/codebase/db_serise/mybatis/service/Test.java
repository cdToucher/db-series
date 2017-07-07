package me.codebase.db_serise.mybatis.service;

import me.codebase.db_serise.mybatis.bean.AppInfo;
import me.codebase.db_serise.mybatis.mappers.AppInfoMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

/**
 * Created by chendong on 2017/7/6.
 */
@Service
public class Test {

//    @Autowired
//    private AppInfoMapper appInfoMapper;

    @Autowired
    private SqlSessionFactory sqlSessionFactory;

    @PostConstruct
    public void init() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        AppInfoMapper mapper = sqlSession.getMapper(AppInfoMapper.class);
        AppInfo bean1 = mapper.selectOne("2222");
//        AppInfo bean3 = appInfoMapper.selectOne("2222");
//        AppInfo bean2 = sqlSession.selectOne("me.codebase.db_serise.mybatis.mappers.AppInfoMapper.selectOne", "2222");
        System.out.println(bean1.toString());
//        System.out.println(bean2.toString());
//        System.out.println(bean3.toString());
    }


}
