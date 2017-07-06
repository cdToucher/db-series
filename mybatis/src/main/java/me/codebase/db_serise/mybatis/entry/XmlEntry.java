package me.codebase.db_serise.mybatis.entry;

import com.google.common.io.Resources;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by chendong on 2017/7/5.
 *
 * xml starter
 */
public class XmlEntry {

    public static void main(String[] args) {
        String path = Resources.getResource("ApplicationContext.xml").getPath();
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(path);
        context.start();
    }

}
