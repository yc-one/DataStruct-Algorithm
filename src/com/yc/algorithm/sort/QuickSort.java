package com.yc.algorithm.sort;
/**
 * 排序算法稳定性: 通俗地讲就是能保证排序前2个相等的数其在序列的前后位置顺序和排序后它们两个的前后位置顺序相同。
 * 如，如果Ai = Aj，Ai原来在位置前，排序后Ai还是要在Aj位置前
 * 快速排序: 平均时间复杂度O(nlgn) 最好的情况O(nlgn)  最坏的情况O(n^2) 空间复杂度O(nlgn)--用到O(nlgn)的栈深度实现递归  不稳定
 * @author YC
 *
 */
public class QuickSort {
	public static void main(String[] args) {
		int[] arr = new int[] {
				34,23,44,21,2,3,65,33,2
		};
		
		partition(arr, 0, arr.length - 1);
		for(int i = 0; i < arr.length; i++)
			System.out.print(arr[i] + " ");
	}
	
	// 分割待排序数组
	public static void partition(int[] arr, int lo, int hi) {
		
		if(lo < hi) {
			// 获取排序后基准点分割后的下标 index
			int index = getIndexAfterSort(arr, lo, hi);
			// 基准点左边的元素(小于 arr[index]),右边全部大于 arr[index]
			// 左边再分割
			partition(arr, lo, index - 1);
			// 右边再分割
			partition(arr, index + 1, hi);
		}
		
	}
	
	/**
	 * 选取数组的第一个元素为基准点进行分割(排序),左边所有元素 <基准点< 右边的所有元素
	 * 
	 * @param arr 待分割数组
	 * @param lo  数组中未和基准点比较的  第一个元素索引
	 * @param hi  数组中未和基准点比较的  最后一个元素索引
	 * @return
	 */
	public static int getIndexAfterSort(int[] arr, int lo, int hi) {
		// 1. 选取第一个为基准点,并保存;可以想象arr[lo]的元素被挖出来,此时 lo 位置有个坑
		int key = arr[lo];
		
		while(lo < hi) {
			// 2. 从最后一个元素开始往前,依次和 基准点 key 进行比较
			while(key < arr[hi] && lo < hi)
				// 3.如果元素小于基准点 key,继续往前扫,直到有一个 < key
				hi--;
			// 4. 从后往前扫,此时找到一个元素小于基准点,
			if(lo < hi) {
				// 5. arr[hi] 填入 lo 处的坑,此时 hi 处有个坑
				arr[lo] = arr[hi];
				lo++;
			}
			// 6. 此时从前往后扫,找到一个比比基准值打的数去填 lo 的坑
			while(key > arr[lo] && lo < hi)	
				lo++;
			if(lo < hi) {
				arr[hi] = arr[lo];
				hi--;
			}
		}
		// 7. 处理完后 lo == hi,key 填入坑中
		arr[lo] = key;
		return lo;
		
	}
}
