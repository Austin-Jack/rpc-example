package cn.llynsyw.boot.impl;

import cn.llynsyw.example.Calculator;

/**
 * TODO
 *
 * @author luolinyuan
 * @date 2022/5/3
 **/
public class MyCalculator implements Calculator {
	@Override
	public int add(int a, int b) {
		return a + b;
	}

	@Override
	public int minus(int a, int b) {
		return a - b;
	}

	@Override
	public double add(double a, double b) {
		return a + b;
	}
}
