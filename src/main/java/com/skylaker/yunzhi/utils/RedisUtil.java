package com.skylaker.yunzhi.utils;

import com.skylaker.yunzhi.config.GlobalConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

/**
 * Created with IntelliJ IDEA.
 * User: zhuyong
 * Date: 2018/5/20 19:50
 * Description:
 *      redis操作工具类
 */
@Component
public class RedisUtil {
    @Autowired
    private RedisTemplate redisTemplate;


    /**
     * 判断hash是否存在指定键
     *
     * @param   hashKey
     * @param   key
     * @return
     */
    public boolean hasHashKey(Object hashKey, Object key){
        return redisTemplate.opsForHash().hasKey(hashKey, key);
    }

    /**
     * 获取hash指定键值
     *
     * @param hashKey
     * @param key
     * @return
     */
    public Object getHashValue(Object hashKey, Object key){
        return redisTemplate.opsForHash().get(hashKey, key);
    }

    /**
     * 添加hash键值
     *
     * @param hashKey
     * @param key
     * @param value
     */
    public void setHashValue(Object hashKey, Object key, Object value){
        redisTemplate.opsForHash().put(hashKey, key, value);
    }

    /**
     * 判断某个值是否存在于指定的set中
     * @param setKey
     * @param value
     * @return
     */
    public boolean existInSet(Object setKey, Object value) {
        return  redisTemplate.opsForSet().isMember(setKey, value);
    }

    /**
     * 往set中添加值
     *
     * @param setKey        目标set
     * @param itemValue     要添加的值
     */
    public void addSetValue(Object setKey, Object itemValue){
        redisTemplate.opsForSet().add(setKey, itemValue);
    }

    /**
     * 往 ZSET 中添加值
     *
     * @param zsetKey
     * @param itemKey
     * @param value
     */
    public void addZsetValue(Object zsetKey, Object itemKey, Double value){
        redisTemplate.opsForZSet().add(zsetKey, itemKey, value);
    }
}