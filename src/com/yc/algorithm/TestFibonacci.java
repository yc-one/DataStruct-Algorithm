package com.yc.algorithm;

import java.util.Scanner;

/**
 * 斐波那契数列:
 * 第一个月: 1 对兔子
 * 第二个月: 1 对兔子
 * 第三个月: 2 对兔子
 * 兔子规律: 1 1 2 3 5 ...
 * F(n) = F(n - 1) + F(n - 2)
 * 递归花费时间:99002
 * 非递归花费时间:13
 * @author YC
 *
 */
public class TestFibonacci {
	
	public static void main(String[] args) {
		
		long start = System.currentTimeMillis();
		for(int i = 1; i <= 50; i++)
			System.out.println("第" + i + " 个月有" + fab(i) + "对兔子");
		long end = System.currentTimeMillis();
		
		System.out.println("递归花费时间:" + (end - start));
		
		start = System.currentTimeMillis();
		for(int i = 1; i <= 50; i++)
			System.out.println("第" + i + " 个月有" + fabNoRecursion(i) + "对兔子");
		end = System.currentTimeMillis();
		
		System.out.println("非递归花费时间:" + (end - start));
		/*System.out.println("请输入第几个月:");
		Scanner input = new Scanner(System.in);
		while(input.hasNext()) {
			int n= input.nextInt();
			System.out.println(n + "个月有" + fab(n) + "对兔子");
			System.out.println("请输入第几个月:");
		}*/
		
	}
	
	public static long fabNoRecursion(int n) {
		
		if(n == 1 || n==2)
			return 1;
		else {
			long first = 0;
			long second = 1;
			long tmp = 0;
			for(int i = 2; i <= n; i++) {
				tmp = first + second;
				first = second;
				second = tmp;
			}
			return second;
		}
		
	}
	
	public static long fab(int n) {
		
		if(n == 1 || n == 2)
			return 1;
		else {
			return fab(n -1) + fab(n - 2);
		}
		
	}
	
}
