package me.codebase.db_serise.mybatis.entry;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by chendong on 2017/7/5.
 * <p>
 * xml starter
 * <p>
 * mybatis 和 spring 结合使用
 */
public class XmlEntry {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
        context.start();
    }

}
