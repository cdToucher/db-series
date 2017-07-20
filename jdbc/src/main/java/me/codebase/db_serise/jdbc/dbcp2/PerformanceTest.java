package me.codebase.db_serise.jdbc.dbcp2;

import me.codebase.db_serise.jdbc.slq.Sql;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

/**
 * Created by chendong on 2017/7/20.
 */
public class PerformanceTest implements Sql{

    public static void main(String[] args) throws SQLException, InterruptedException {
        System.out.println("dbcp2 test");
        final int j = 1000;
        Connection connection = ConnectionManager.getConn();
        ExecutorService service = Executors.newFixedThreadPool(10);
        long start = System.currentTimeMillis();
        System.out.println(start);
        for (int i = 0; i < 10; i++) {
            service.submit(() -> IntStream.range(0, j).forEach(n -> {
                try {
                    Statement statement = connection.createStatement();
                    statement.execute(sql1);
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }));
        }
        service.shutdown();
        service.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
        doStop(j, start);
    }

    private static void doStop(int j, long start) {
        long end = System.currentTimeMillis();
        System.out.println(end);
        System.out.println(end - start);
        System.out.println((double) (j * 10000) / (end - start));
    }

}
