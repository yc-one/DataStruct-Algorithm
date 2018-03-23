package com.yc.algorithm;

/**
 * 判断素数:
 * 用一个数分别去除 2 -- Math.sqrt(这个数),如果能被整除说明该数不是素数
 * @author YC
 *
 */
public class TestPrime {
	public static void main(String[] args) {
		
		System.out.println("100000以内的素数:");
		for(int i = 1; i < 100_000; i+=2) {
			if(isPrime(i))
				System.out.println(i);
		}
	}
	
	public static boolean isPrime(int n) {
		
		// 如果能被整除说明不是素数
		for(int i = 2; i <= Math.sqrt(n); i++) {
			if(n % i == 0)
				return false;
		}
		// 不能整除,是素数
		return true;
		
	}
}
