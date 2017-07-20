package me.codebase.db_serise.jdbc.dbcp2;

import com.google.common.io.Resources;
import org.apache.commons.dbcp2.BasicDataSource;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Created by chendong on 2017/7/20.
 */
public class ConnectionManager {

    protected static Connection conn = null;
    // 创建数据库连接对象 ( 数据源 )
    private static BasicDataSource dataSource = new BasicDataSource();

    static {
        try {
            DataSourceConfig();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void DataSourceConfig() throws IOException {
        URL url = Resources.getResource("application.properties");
        Properties properties = new Properties();
        properties.load(new FileInputStream(new File(url.getPath())));
        dataSource.setDriverClassName(properties.getProperty("spring.datasource.driver-class-name")); //数据库驱动
        dataSource.setUsername(properties.getProperty("spring.datasource.username"));  //用户名
        dataSource.setPassword(properties.getProperty("spring.datasource.password"));  //密码
        dataSource.setUrl(properties.getProperty("spring.datasource.url"));  //连接url
        dataSource.setInitialSize(10); // 初始的连接数；
        dataSource.setMaxTotal(20);  //最大连接数
        dataSource.setMaxIdle(10);  // 设置最大空闲连接
        dataSource.setMaxWaitMillis(3000);  // 设置最大等待时间
        dataSource.setMinIdle(10);  // 设置最小空闲连接
    }

    public static Connection getConn() {
        try {
            // 从连接池中获得连接对象
            if (conn == null) {
                conn = dataSource.getConnection();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }
}
