package me.codebase.db_serise.jpa.repository;


import me.codebase.db_serise.jpa.entity.AppInfo;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by chendong on 2017/7/10.
 * <p>
 * example for jpa repository
 */
public interface ApplicationRepository extends JpaRepository<AppInfo, Long> {

    AppInfo findByAppId(String id);


}
