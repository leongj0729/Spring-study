package edu.nf.ch08_2.dao;

import edu.nf.ch08_2.entity.Users;

import java.util.List;

public interface UserDao {

    /**
     *
     * @return
     */
    List<Users> listUser();
}
