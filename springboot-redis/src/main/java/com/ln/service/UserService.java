package com.ln.service;
import com.ln.entity.User;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Cacheable(cacheNames = "c1")//,keyGenerator = "myKeyGenerator") //启用缓存 name就是起的名字在配置文件
    public User getUserById(Integer id) {
        System.out.println("getUserById传进来的Id" + id);

        User user = new User();
        user.setId(1);
        user.setUsername("Sansa");
        user.setAddress("USA");


        return user;
    }

    // 如果删除了 那么请把缓存也清除 不然会出现藏的数据
    @CacheEvict(cacheNames = "c1")
    public void deleteUserById(Integer id) {

        System.out.println("deleteUserById传进来的id" + id);


    }


    // 更新操作
    @CachePut(cacheNames = "c1")
    public User updateUserById(Integer id) {

        System.out.println("updateUserById传进来的Id" + id);
        User user = new User();
        user.setId(id);
        user.setUsername("collins");
        user.setAddress("USA");

        return user;

    }

    //更新操作二
    @CachePut(key = "#user.id")
    public User updateUser(User user) {
        return user;
    }
}
