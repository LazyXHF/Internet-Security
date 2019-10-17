package cn.xu.ehcache.mapper;

import cn.xu.ehcache.pojo.User;
import org.apache.ibatis.annotations.Select;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;

/**
 * @author ~许小桀
 * @date 2019/10/14 11:00
 */
@CacheConfig(cacheNames = "userCache")
@Repository
public interface CacheService {



    @Select("SELECT * FROM demo t WHERE t.`id` = 1")
    @Cacheable
    User getUser();
}
