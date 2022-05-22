package cn.llynsyw.boot;

import cn.llynsyw.boot.impl.MyCalculator;
import cn.llynsyw.boot.impl.SortImpl;
import cn.llynsyw.example.Calculator;
import cn.llynsyw.example.Sort;
import com.foolrpc.rpc.FoolRpcServerFactory;
import com.foolrpc.rpc.server.RpcServer;
import lombok.extern.slf4j.Slf4j;


/**
 * rpc服务启动类
 *
 * @Author luolinyuan
 * @date 2022/4/11
 **/
@Slf4j
public class Server {
	public static void main(String[] args) {
		/*新建一个rpc服务*/
		RpcServer server = FoolRpcServerFactory.createServer();

		/*注册计算器服务*/
		server.register(Calculator.class, new MyCalculator());

		server.register(Sort.class, new SortImpl());

		server.start();
	}
}
