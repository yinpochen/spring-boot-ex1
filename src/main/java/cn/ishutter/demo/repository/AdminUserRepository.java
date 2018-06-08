package cn.ishutter.demo.repository;

import cn.ishutter.demo.entity.AdminUser;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminUserRepository extends MongoRepository<AdminUser,Integer> {
    AdminUser findByUserName(String userName);
}
