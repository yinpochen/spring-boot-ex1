package cn.ishutter.demo.entity;

import lombok.Data;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Document(collection = "adminuser")
@Data
public class AdminUser {
    @Id
    private Integer userId;
    @NotNull
    @Indexed(unique = true)
    private String userName;
    @NotNull
    private String password;
    @NotNull
    private String name;
    @NotNull
    private String email;
    public AdminUser(){

    }

    @PersistenceConstructor
    public AdminUser(Integer userId,String userName,String password,String name,String email){
        this.userId = userId;
        this.userName = userName;
        this.password = password;
        this.name = name;
        this.email = email;
    }
}
