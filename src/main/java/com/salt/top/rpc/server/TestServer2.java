package com.salt.top.rpc.server;


import com.salt.top.rpc.service.CoffeeService;
import com.salt.top.rpc.service.CoffeeServiceImpl;
import com.salt.top.rpc.service.UserService;
import com.salt.top.rpc.service.UserServiceImpl;

public class TestServer2 {
    public static void main(String[] args) {
        UserService userService = new UserServiceImpl();
        CoffeeService coffeeService = new CoffeeServiceImpl();

        ServiceProvider serviceProvider = new ServiceProvider("127.0.0.1", 8900);
        serviceProvider.provideServiceInterface(userService);
        serviceProvider.provideServiceInterface(coffeeService);
        RPCServer RPCServer = new NettyRPCServer(serviceProvider);

        RPCServer.start(8900);
    }
}
