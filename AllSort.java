package Sort;

public class AllSort
{
	public static void main(String[] args)
	{
		int[] a = { 2, 0, 1, 4, 3, 5, 67, 6, 4, 56, 7 };
		// 冒泡
		// maopao(a);

		// 该进冒泡
		// gaijinmapopao(a);

		// 简单选择排序
		// xuanzepaixu(a);

		// 插入排序
		// charupaixu(a);

		// 快排
		// if (a.length > 0)
		// AllSort.kuaipai(a, 0, a.length - 1);

		// 归并
		guibing(a, 0, a.length - 1);

		for (int i = 0; i < a.length; i++)
		{
			System.out.print(a[i] + " ");
		}
	}

	private static void guibing(int[] a, int left, int right)
	{
		if (left >= right)
			return;
		int mid = (left + right) / 2;
		guibing(a, left, mid);
		guibing(a, mid + 1, right);
		merger(a, left, mid, right);
	}

	private static void merger(int[] a, int left, int mid, int right)
	{
		int[] temp = new int[right - left + 1];
		int k = 0;
		int i = left;
		int j = mid + 1;
		while (i <= mid && j <= right)
		{
			if (a[i] < a[j])
			{
				temp[k++] = a[i++];
			}
			else
			{
				temp[k++] = a[j++];
			}
		}
		while (i <= mid)
			temp[k++] = a[i++];
		while (j <= right)
			temp[k++] = a[j++];
		for (int j2 = 0; j2 < temp.length; j2++)
		{
			a[left + j2] = temp[j2];
		}
	}

	private static void kuaipai(int[] a, int i, int j)
	{
		if (i >= j)
			return;
		int index = kuaipaisort(a, i, j);
		kuaipai(a, i, index - 1);
		kuaipai(a, index + 1, j);
	}

	private static int kuaipaisort(int[] a, int i, int j)
	{
		int base = a[i];
		while (i < j)
		{
			while (i < j && a[j] >= base)
				j--;
			if (i < j)
				a[i++] = a[j];
			while (i < j && a[i] <= base)
				i++;
			if (i < j)
				a[j--] = a[i];
		}
		a[i] = base;
		return i;
	}

	/**
	 * @param a 疑惑去点temp 值不一样
	 */
	private static void charupaixu(int[] a)
	{
		for (int i = 1; i < a.length; i++)
		{
			int temp = a[i];
			int j;
			for (j = i; j > 0; j--)
			{
				if (temp < a[j - 1])
				{
					a[j] = a[j - 1];
				}
				else
				{
					break;
				}
			}
			a[j] = temp;
		}
	}

	private static void xuanzepaixu(int[] a)
	{
		for (int i = 0; i < a.length - 1; i++)
		{
			// 记下目前找到的最小值所在的位置
			int k = i;
			for (int j = i + 1; j < a.length; j++)
			{
				if (a[k] > a[j])
				{
					k = j;
				}
			}
			int temp = a[k];
			a[k] = a[i];
			a[i] = temp;

		}
	}

	private static void gaijinmapopao(int[] a)
	{
		boolean flag = false;
		for (int i = 0; i < a.length; i++)
		{
			for (int j = 0; j < a.length - i - 1; j++)
			{
				if (a[j] > a[j + 1])
				{
					int temp = a[j];
					a[j] = a[j + 1];
					a[j + 1] = temp;
					flag = true;
				}
			}
			if (!flag)
			{
				break;
			}
		}
	}

	private static void maopao(int[] a)
	{
		for (int i = 0; i < a.length; i++)
		{
			for (int j = 0; j < a.length - i - 1; j++)
			{
				if (a[j] > a[j + 1])
				{
					int temp = a[j];
					a[j] = a[j + 1];
					a[j + 1] = temp;
				}
			}
		}
	}
}
