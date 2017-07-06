package me.codebase.db_serise.mybatis.entry;

import me.codebase.db_serise.mybatis.config.AppConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by chendong on 2017/7/5.
 *
 * mybatis start with java config
 */
public class JavaConfigEntry {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        context.start();
    }
}
