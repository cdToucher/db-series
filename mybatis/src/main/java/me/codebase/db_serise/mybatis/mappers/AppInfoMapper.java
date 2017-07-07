package me.codebase.db_serise.mybatis.mappers;

import me.codebase.db_serise.mybatis.bean.AppInfo;
import org.apache.ibatis.annotations.Select;

/**
 * Created by chendong on 2017/7/6.
 */
public interface AppInfoMapper {

//    AppInfo selectOne(String appId);

//    @Select("SELECT * FROM app_info WHERE app_id = #{id}")
    AppInfo selectOne(String id);
}
