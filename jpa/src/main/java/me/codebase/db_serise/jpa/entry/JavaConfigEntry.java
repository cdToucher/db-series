package me.codebase.db_serise.jpa.entry;

import me.codebase.db_serise.jpa.config.AppConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by chendong on 2017/7/7.
 */
public class JavaConfigEntry {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context= new AnnotationConfigApplicationContext(AppConfig.class);
        context.start();
    }

}
