package com.yc.algorithm.sort;

/**希尔排序
 * 时间复杂度O(nlgn) 最坏 O(n^2) 最好 O(n) 空间复杂度 O(1) 不稳定
 * 希尔排序关键点--选取步长
 * [1, 5, 3, 6, 8, 7, 2, 4]
 * 1) arr.length/2 = 4,选取步长为4
 * 2) 步长为4,所以前 4 先不需要考虑,从 arr[4] 即第五个元素开始,和4个步长前的元素相比
 * 3) 8 比 1 大,所以直接进入下一步
 * 4) arr[5] 即第 6 个元素开始和 4步长前的元素 5 相比,arr[5] > arr[1] 进入下一流程
 * 5) arr[6]=2 < arr[2]=3 ,交换
 * 6) 交换之后arr[2] = 2 , arr[2] 再往前 4 个步长相比,arr[-2]发现不在数组中,进入下一比较
 * 7) arr[7]=4 < arr[3] = 6,交换
 * 8) arr[3] = 4,和 前四个步长 比较,发现arr[3-4] 不在数组中.
 * 9) 此时,步长为 4 的排序流程结束,开始 步长为 4/2=2的步长开始排序
 * @author YC
 *
 */
public class ShellSort {
	public static void main(String[] args) {
		int[] arr = new int[] {
				1, 5, 3, 6, 8, 7, 2, 4
		};
		
		Sort(arr);
		System.out.println("最终排序结果:");
		show(arr);
	}

	public static void Sort(int[] arr) {
		
		// 初始步长为arr.length/2,直到步长为 1 时,为最后一趟排序
		for(int step = arr.length/2; step > 0; step/=2) {
			
			// 从 arr[i]开始,与前  arr[i - step] 个元素比较,并排序
			for (int i = step; i < arr.length; i++)
            {
				//
                int temp = arr[i];
                int j;
                
                // 如果 i - step > 0,说明可以和前 step位的元素即 arr[i - step] 比较,如果 arr[i - step] > arr[i] 则交换
                // 如果 i -step < 0,数组下标 < 0,不需要再比较,交换过程停止
                for(j = i - step; j >= 0 && arr[j] > temp; j = j - step)
                {
                	// 把当前元素的 前 [步长] 位的元素挖出,赋值给当前元素(即 arr[i] = arr[j])
                	// 注,arr[i]原始值 已经保存在 temp 中
                	// 如果 arr[j] 的前 [步长] 位 即arr[j - 步长] 存在,arr[j - k] 继续与 arr[i] 比较,重复以上流程
                    arr[j + step] = arr[j];
                }
                // 1) 没有经过 for 循环, 即 arr[j] < tmp, 说明某步长的该次比较不用交换, 但是 for 循环中已经初始化了 j = i - step
                // 	arr[j + step] == arr[i] == tmp
                
                // 2) 经过了 for 循环后, j = j - step < 0,退出循环,赋值给 arr[j + step]
                arr[j + step] = temp;
            }
			
			System.out.println("步长为" + step + ":");
			show(arr);
		}
		
	}
	
	private static void show(int[] arr) {
		for(int i = 0; i < arr.length; i++)
			System.out.print(arr[i] + " ");
		System.out.println();
	}
	
}
