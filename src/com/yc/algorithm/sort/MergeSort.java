package com.yc.algorithm.sort;

/**
 * 归并排序: 采用分治算法,平均时间复杂度O(nlgn),最坏情况O(nlgn),最好情况O(nlgn),空间复杂度O(n) 稳定
 * @author YC
 *
 */
public class MergeSort {
	
	public static void main(String[] args) {
		// 初始化数组
		int[] arr = new int[] {34,23,44,21,2,3,65,33,2};
		
		partition(arr, 0, arr.length - 1);
		
		for(int i = 0; i < arr.length; i++)
			System.out.print(arr[i] + " ");
		
	}
	
	public static void partition(int[] arr, int lo, int hi) {
		
		// 接收到一个新数组,划分为两个子数组,再递归,合并
		// 1. 平均划分数组
		if(lo < hi) {
			
			int mid = (lo + hi) / 2;
			
			// 2. 递归划分至最小
			partition(arr, lo, mid);
			partition(arr, mid + 1, hi);
			
			// 3. 合并两个有序数组
			Merge(arr, lo, hi, mid);
			
		}
	}

	private static void Merge(int[] arr, int lo, int hi, int mid) {
		
		// 初始化数组,储存两个有序数组的元素
		int[] tmp = new int[arr.length];
		
		// 保存A数组的第一个和最后一个索引
		int fisrtBeginIndex = lo;
		int fisrtEndIndex = mid;
		// 保存B数组的第一个和最后一个索引
		int secondBeginIndex = mid + 1;
		int secondEndIndex = hi;
		
		// 初始化临时数组的第一个元素索引
		int tmpIndex = lo;
		
		// 记录 A子数组的以第一个索引,为临时数组赋值给源数组所准备
		int temp = lo;
		while(fisrtBeginIndex <= fisrtEndIndex && secondBeginIndex <= secondEndIndex) {
			// 比较两数组第一个元素,小的加入tmp数组
			if(arr[fisrtBeginIndex] <= arr[secondBeginIndex])
				tmp[tmpIndex++] = arr[fisrtBeginIndex++];
			else
				tmp[tmpIndex++] = arr[secondBeginIndex++];
			
		}
		
		// 第一数组中还有元素剩余
		while(fisrtBeginIndex <= fisrtEndIndex) {
			tmp[tmpIndex++] = arr[fisrtBeginIndex++];
		}
		while(secondBeginIndex <= secondEndIndex) {
			tmp[tmpIndex++] = arr[secondBeginIndex++];
		}
		
		// tmp数组中元素赋值给源数组,切忌以下做法,因为每次合并的数组都是以刚传进来的第一个子数组的 第一个索引(firstIndex)开始
		// 但,firstBeginIndex 不是以 0 开始的索引
		//for(int i = 0; i < arr.length; i++)
		//	arr[i] = tmp[i];
		
		while(temp <= hi)
			arr[temp] = tmp[temp++];
		
	}
	
}
