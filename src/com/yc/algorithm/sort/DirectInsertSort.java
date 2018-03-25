package com.yc.algorithm.sort;

/**
 * 直接插入排序:
 * 平均时间复杂度O(n^2)  最好 O(n)   最坏 O(n^2)    空间复杂度O(1)   稳定 
 * 
 * @author YC
 *
 */
public class DirectInsertSort {
	public static void main(String[] args) {
		int[] arr = new int[] {34,23,44,21,2,3,65,33,2 };
		
		Sort(arr);
		
		for(int i = 0; i < arr.length; i++)
			System.out.print(arr[i] + " ");
	}
	
	public static void Sort(int[] arr) {
		
		// 第2个元素为带排序数,依次递增,插入已排序的数组中
		for(int i = 1; i < arr.length; i++) {
			// 保存待插入的数
			int tmp = arr[i];
			int j;
			for(j = i - 1; j >= 0; j--) {
				if(arr[j] > tmp) {
					// 后退一位
					arr[j+1] = arr[j];
					// 后退会覆盖原有的arr[i],所以预先要保存tmp=arr[i]
				}
				else
					break;
			}
			// for 循环退出时,j--,所以 tmp赋值给 arr[j+1]
			arr[j+1] = tmp;
		}
		
	}
}
