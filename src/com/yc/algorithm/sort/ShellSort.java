package com.yc.algorithm.sort;

/**希尔排序
 * 时间复杂度O(nlgn) 最坏 O(n^2) 最好 O(n) 空间复杂度 O(1) 不稳定
 * @author YC
 *
 */
public class ShellSort {
	public static void main(String[] args) {
		int[] arr = new int[] {
				34,23,44,21,2,3,65,33,2
		};
		
		Sort(arr);
		for(int i = 0; i < arr.length; i++)
			System.out.print(arr[i] + " ");
	}
	
	public static void Sort(int[] arr) {
		
		// 初始步长为arr.length/2
		for(int step = arr.length/2; step > 0; step/=2) {
			for (int i = step; i < arr.length; i++)
            {
                int temp = arr[i];
                int j;
                for(j = i - step; j >= 0 && arr[j] > temp; j = j - step)
                {
                    arr[j + step] = arr[j];
                }
                arr[j + step] = temp;
            }

		}
		
	}
}
