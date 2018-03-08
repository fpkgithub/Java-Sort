package sort;

/**
 * @time   Mar 8, 2018
 * @author akun
 * @description  
 */
public class quicksort
{
	public static void main(String[] args)
	{
		int[] arr = { 50, 10, 90, 30, 70, 0 };
		sort(arr);
		for (int value : arr)
		{
			System.out.print(value + " ");
		}
	}

	/**
	 * @param arr
	 */
	private static void sort(int[] arr)
	{
		QuickSort(arr, 0, arr.length - 1);
	}

	/**
	 * @param arr
	 * @param i
	 * @param j
	 */
	private static void QuickSort(int[] arr, int low, int hight)
	{
		if (arr.length == 0 || low < 0 || hight >= arr.length)
		{
			return;
		}
		int index = qstort(arr, low, hight);
		qstort(arr, low, index - 1);
		qstort(arr, index + 1, hight);
	}

	/**
	 * @param arr
	 * @param i
	 * @param hight
	 */
	private static int qstort(int[] arr, int low, int hight)
	{
		int base = arr[low];
		while (low < hight)
		{
			while (low < hight && arr[hight] >= base)
			{
				hight--;
			}
			// swap(arr, low, hight);
			if (low < hight)
			{
				arr[low++] = arr[hight];
			}
			while (low < hight && arr[low] <= base)
			{
				low++;
			}
			// swap(arr, low, hight);
			if (low < hight)
			{
				arr[hight--] = arr[low];
			}
		}
		// 注意注意
		arr[low] = base;
		return low;
	}

	/**
	 * @param arr
	 * @param low
	 * @param hight
	 */
	private static void swap(int[] arr, int low, int hight)
	{
		int temp = arr[low];
		arr[low] = arr[hight];
		arr[hight] = temp;
	}
}
