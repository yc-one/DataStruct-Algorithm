package com.yc.algorithm.sort;

// 冒泡排序
// 平均时间复杂度: O(n^2)   最坏情况: O(n^2)  最好情况 O(n)  稳定
// 最好情况下: 第一趟一次都没有交换数据,说明数组本身就是有序,不用再循环,直接跳出(使用 boolean isSwap 标记)
public class BubbleSort {
	
	public static void main(String[] args) {
		// 34,23,44,21,2,3,65,33,2
		int[] arr = new int[] {34,23,44,21,2,3,65,33,2 };
		
		sort(arr);
		
		System.out.println("-------输出最终的数组：");
		for(int i = 0; i < arr.length; i++)
			System.out.print(arr[i] + " ");
	}
	
	public static void sort(int[] arr) {
		
		for(int i = 0; i < arr.length - 1; i++) {
			boolean isSwap = false;
			System.out.println("第 " + i + "次排序:");
			for(int j = 0; j < arr.length - i - 1; j++) {
				if(arr[j] > arr[j + 1]) {
					int tmp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = tmp;
					isSwap = true;
				}
				for(int k = 0; k < arr.length; k++)
					System.out.print(arr[k] + " ");
				System.out.println();
			}
			// 第一趟没有发生交换说明数组本来就是有序,直接返回,剩下的 i=1 - arr.length - 2 都不用在执行了,
			// 所以 最好情况下时间复杂度O(n)
			if(!isSwap)
				return;
		}
		
	}
	
	
	
}
