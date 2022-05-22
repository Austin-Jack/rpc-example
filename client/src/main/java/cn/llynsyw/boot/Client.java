package cn.llynsyw.boot;

import cn.llynsyw.example.Calculator;
import cn.llynsyw.example.Sort;
import com.foolrpc.rpc.FoolRpcClientFactory;
import com.foolrpc.rpc.client.RpcClient;

import java.util.Random;

/**
 * RPC 客户端
 *
 * @Author luolinyuan
 * @date 2022/4/11
 **/
public class Client {
	public static void main(String[] args) throws InterruptedException {
		//通过RpcClient发生调用请求
		RpcClient client = FoolRpcClientFactory.creatClient();
		Calculator calculator = client.getProxy(Calculator.class);

		Sort sort = client.getProxy(Sort.class);

		int addResult = calculator.add(10, 18);
		int minusResult = calculator.minus(100, 7);

		double addDouble = calculator.add(1.12, 12.2);
		Random random = new Random();
		int size = random.nextInt(1000);
		int[] array = new int[size];
		for (int i = 0; i < size; i++) {
			array[i] = random.nextInt(10000);
		}
		sort.quicksort(array);
		for (int j : array) {
			System.out.print(j + " ");
		}
		System.out.println();
		System.out.println("addResult: " + addResult);
		System.out.println("minusResult: " + minusResult);
		System.out.println("addDouble: " + addDouble);

	}
}
