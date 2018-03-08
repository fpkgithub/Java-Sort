package sort;

import org.junit.Test;

/**
 * @time   Mar 8, 2018
 * @author akun
 * @description  
 */
public class MergeSort
{
	@Test
	public void sort()
	{
		int[] arr = { 1, 3, 4, 12, 3, 45 };
		int a[] = fun(arr, 0, arr.length - 1);
		for (int value : a)
		{
			System.out.print(value + " ");
		}
	}

	/**
	 * @param arr
	 */
	private int[] fun(int[] arr, int left, int right)
	{
		if (left < right)
		{
			int mid = (left + right) / 2;
			fun(arr, left, mid);
			fun(arr, mid + 1, right);
			merge(arr, left, mid, right);
			return arr;

		}
		return arr;
	}

	/**
	 * @param arr
	 * @param left
	 * @param mid
	 * @param right
	 */
	private void merge(int[] arr, int left, int mid, int right)
	{
		// 新数组
		int[] temp = new int[right - left + 1];
		int i = left;
		int j = mid + 1;
		int k = 0;
		// 将较小的移动到新数组
		while (i <= mid && j <= right)
		{
			if (arr[i] < arr[j])
			{
				temp[k++] = arr[i++];
			}
			else
			{
				temp[k++] = arr[j++];
			}
		}
		// 将左边剩余的数复制到数组
		while (i <= mid)
		{
			temp[k++] = arr[i++];
		}
		// 将右边剩余的数复制到数组
		while (j <= right)
		{
			temp[k++] = arr[j++];
		}
		for (int n = 0; n < temp.length; n++)
		{
			arr[n + left] = temp[n];
		}
	}

}
