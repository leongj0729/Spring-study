package edu.nf.ch07.demo1.impl;

import edu.nf.ch07.demo1.UserService;

/**
 * @author LJJ
 * @date 2020/12/2
 */
public class UserServiceImpl implements UserService {

    @Override
    public void add() {
        System.out.println("Save user...");
    }
}