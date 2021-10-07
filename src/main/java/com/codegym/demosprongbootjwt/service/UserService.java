package com.codegym.demosprongbootjwt.service;

import com.codegym.demosprongbootjwt.model.User;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    public static List<User> listUser = new ArrayList<User>();
    static {
        User userKai = new User(1, "kai", "123456");
        userKai.setRoles(new String[] { "ROLE_ADMIN" });
        User userSena = new User(2, "sena", "123456");
        userSena.setRoles(new String[] { "ROLE_USER" });
        listUser.add(userKai);
        listUser.add(userSena);
    }
// tra ve 1 list cac tai khoan user
    public List<User> findAll() {
        return listUser;
    }

//    Tim 1 user theo id
    public User findById(int id) {
        for (User user : listUser) {
            if (user.getId() == id) {
                return user;
            }
        }
        return null;
    }
//    them 1 user vao listuser
    public boolean add(User user) {
        for (User userExist : listUser) {
            if (user.getId() == userExist.getId() || StringUtils.equals(user.getUsername(), userExist.getUsername())) {
                return false;
            }
        }
        listUser.add(user);
        return true;
    }
// xoa 1 tai khoan khoi listuser
    public void delete(int id) {
        listUser.removeIf(user -> user.getId() == id);
    }
    public User loadUserByUsername(String username) {
        for (User user : listUser) {
            if (user.getUsername().equals(username)) {
                return user;
            }
        }
        return null;
    }
//    kiem tra xem user nhap vao cos dung vs du lieu ytren listuser ko
    public boolean checkLogin(User user) {
        for (User userExist : listUser) {
            if (StringUtils.equals(user.getUsername(), userExist.getUsername())
                    && StringUtils.equals(user.getPassword(), userExist.getPassword())) {
                return true;
            }
        }
        return false;
    }
}
