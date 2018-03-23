package com.yc.algorithm;

import org.junit.jupiter.api.Test;

/**
 * 1. 判断水仙花数
 * 2. 
 * 
 * 
 * @author YC
 *
 */

class TestInJunit {
	
	@Test
	public void testJieCheng() {
		
	}
	
	// 分解质因数
	@Test
	public void testPartionNum() {
		getNum(500);
	}
	
	public void getNum(int num) {
		int a = 2;
		System.out.print(num + "=");
		while(num > a) {
			if(num % a == 0) {
				System.out.print(a + "*");
				num = num / a;
			}
			else
				a++;
		}
		System.out.println(a);
	}
	
	/**
	 * 水仙花数: 指一个三位数,各位数字立方和等于该数本身
	 */
	@Test
	void testNarcissistic() {
		System.out.println("水仙花数:");
		for(int i = 100; i < 999; i++)
			if(isNarcissistic(i))
				System.out.print(i + " ");
	}
	
	public boolean isNarcissistic(int n) {
		// 个位
		int unitDigit = n % 10;
		// 十位: 先 % 100 得到十位个位,再 / 10 得到十位
		int tenDigit = (n % 100) / 10;
		// 百位
		int hdrDigit = n / 100;
		
		int sum = (int) (Math.pow(unitDigit, 3) + Math.pow(tenDigit, 3) + Math.pow(hdrDigit, 3));
		
		if(sum == n)
			return true;
		return false;
	}

}
