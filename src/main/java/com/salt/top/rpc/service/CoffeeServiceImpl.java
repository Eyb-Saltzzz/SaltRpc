package com.salt.top.rpc.service;


import com.salt.top.rpc.common.Coffee;

public class CoffeeServiceImpl implements CoffeeService {
    @Override
    public Coffee getCoffeeById(Integer id) {
        Coffee coffee = Coffee.builder().id(id).name("123").build();
        System.out.println("客户端查询了"+id+"咖啡");
        return coffee;
    }
}
