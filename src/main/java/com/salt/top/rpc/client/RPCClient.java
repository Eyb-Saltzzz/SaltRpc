package com.salt.top.rpc.client;


import com.salt.top.rpc.common.RPCRequest;
import com.salt.top.rpc.common.RPCResponse;

public interface RPCClient {
    RPCResponse sendRequest(RPCRequest request);
}
