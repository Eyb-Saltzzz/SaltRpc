package com.salt.top.rpc.client;


import com.salt.top.rpc.common.Coffee;
import com.salt.top.rpc.common.User;
import com.salt.top.rpc.service.CoffeeService;
import com.salt.top.rpc.service.UserService;

public class TestClient {
    public static void main(String[] args) {
        // 构建一个使用java Socket/ netty/....传输的客户端
        RPCClient rpcClient = new NettyRPCClient();
        // 把这个客户端传入代理客户端
        RPCClientProxy rpcClientProxy = new RPCClientProxy(rpcClient);
        // 代理客户端根据不同的服务，获得一个代理类， 并且这个代理类的方法以或者增强（封装数据，发送请求）
        UserService userService = rpcClientProxy.getProxy(UserService.class);
        // 调用方法
        User userByUserId = userService.getUserByUserId(10);
        System.out.println("从服务端得到的user为：" + userByUserId);

        User user = User.builder().userName("张三").id(100).build();
        Integer integer = userService.insertUserId(user);
        System.out.println("向服务端插入数据："+integer);

        CoffeeService coffeeService = rpcClientProxy.getProxy(CoffeeService.class);

        Coffee coffee = coffeeService.getCoffeeById(10000);
        System.out.println("从服务端得到的coffee为：" + coffee);
        // 测试json调用空参数方法
        System.out.println(userService.hello());

    }
}
