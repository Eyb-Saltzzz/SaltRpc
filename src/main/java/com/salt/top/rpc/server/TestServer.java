package com.salt.top.rpc.server;


import com.salt.top.rpc.service.CoffeeService;
import com.salt.top.rpc.service.CoffeeServiceImpl;
import com.salt.top.rpc.service.UserService;
import com.salt.top.rpc.service.UserServiceImpl;

public class TestServer {
    public static void main(String[] args) {
        UserService userService = new UserServiceImpl();
        CoffeeService coffeeService = new CoffeeServiceImpl();
        // 这里重用了服务暴露类，顺便在注册中心注册，实际上应分开，每个类做各自独立的事
        ServiceProvider serviceProvider = new ServiceProvider("127.0.0.1", 9900);
        serviceProvider.provideServiceInterface(userService);
        serviceProvider.provideServiceInterface(coffeeService);

        RPCServer RPCServer = new NettyRPCServer(serviceProvider);
        RPCServer.start(9900);
    }
}