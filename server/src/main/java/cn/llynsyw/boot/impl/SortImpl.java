package cn.llynsyw.boot.impl;


import cn.llynsyw.example.Sort;


/**
 * @author luolinyuan
 */
public class SortImpl implements Sort {
	@Override
	public int[] bubbleSort(int[] array) {
		if (array == null || array.length <= 1) {
			return array;
		}
		int len = array.length;
		for (int i = len - 1; i >= 0; i--) {
			for (int j = 0; j < i; j++) {
				if (array[j] > array[j + 1]) {
					swap(array, j, j + 1);
				}
			}
		}
		return array;
	}

	@Override
	public int[] quicksort(int[] array) {
		if (array == null || array.length < 2) {
			return array;
		}
		quicksort2(array, 0, array.length - 1);
		return array;
	}

	static void quicksort2(int arr[], int l, int r) {
		if (l >= r) {
			return;
		}
		swap(arr, l + (int) (Math.random() * (r - l + 1)), r);
		int[] p = partition(arr, l, r);
		quicksort2(arr, l, p[0] - 1);
		quicksort2(arr, p[1] + 1, r);
	}

	static int[] partition(int[] arr, int l, int r) {
		int less = l - 1;
		int more = r;
		while (l < more) {
			if (arr[l] < arr[r]) {
				swap(arr, ++less, l++);
			} else if (arr[l] > arr[r]) {
				swap(arr, --more, l);
			} else {
				l++;
			}
		}
		swap(arr, more, r);
		return new int[]{less + 1, more};
	}

	static void swap(int[] arr, int i, int j) {
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}
}
