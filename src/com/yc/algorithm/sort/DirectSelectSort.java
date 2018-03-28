package com.yc.algorithm.sort;

/**
 * 直接选择排序:
 * 平均时间复杂度 O(n^2)  最好O(n^2)  最坏O(n^2) 空间复杂度O(1) 不稳定
 * @author YC
 *
 */
public class DirectSelectSort {
	
	public static void main(String[] args) {
		int[] arr = new int[] {
				34,23,44,21,2,3,65,33,2
		};
		Sort(arr);
		show(arr);
	}
	
	public static void Sort(int[] arr) {
		
		for(int i = 0; i < arr.length; i++) {
			int min = arr[i];
			int minIndex = i;
			// 遍历剩余的数字找到最小的数,如果找到 一个数 < min,则交换
			for(int j = i + 1; j < arr.length; j++) {
				
				if(arr[j] < arr[minIndex]) {
					
					minIndex = j;
				}
			}
			
			// minIndex 如果发生改变,即初始选定的不是最小值,交换使最小的数放到最前面
			if(minIndex != i) {
				int tmp = arr[minIndex];
				arr[minIndex] = arr[i];
				arr[i] = tmp;
			}
		}
		
	}
	
	public static void show(int arr[]) {
		for(int i = 0; i < arr.length; i++)
			System.out.print(arr[i] + " ");
	}
	
}
