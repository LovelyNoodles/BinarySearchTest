package com.algorithm.binarySearch.templateIII;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @description 在一个有序数组（集合）里，找一个距离x最近的k个元素的数组
 *              1.因为数组有序，所以返回的k个元素的数组一定是连续、有序且为这个有序数组的子数组（子集）
 *              2.这个子数组的起始索引index一定在0~arr.length-k中） 3.寻找这个子集的起始索引index
 * 
 *              Example 1: Input: [1,2,3,4,5], k=4, x=3 Output: [1,2,3,4]
 * 
 *              Example 2: Input: [1,2,3,4,5], k=4, x=-1 Output: [1,2,3,4]
 * 
 *              Example 3: Input: [1,2,3,4,5], k=4, x=7 Output: [1,2,3,4]
 * 
 * @author Administrator
 */
public class ClosestElements {

	static class Solution {
		public List<Integer> findClosestElements(int[] arr, int k, int x) {
			int l = 0;
			int r = arr.length - k;
			while (l < r) {
				int m = l + ((r - l) >> 1);
				int min = arr[m];
				int max = arr[m + k];
				if (x - min > max - x) {
					l = m + 1;
				} else {
					r = m;
				}
			}

			int[] range = Arrays.copyOfRange(arr, l, l + k);
			List<Integer> result = new ArrayList<Integer>();
			for (int i : range) {
				result.add(i);
			}
			return result;
		}
	}

	public static int[] stringToIntegerArray(String input) {
		input = input.trim();
		input = input.substring(1, input.length() - 1);
		if (input.length() == 0) {
			return new int[0];
		}

		String[] parts = input.split(",");
		int[] output = new int[parts.length];
		for (int index = 0; index < parts.length; index++) {
			String part = parts[index].trim();
			output[index] = Integer.parseInt(part);
		}
		return output;
	}

	public static String integerArrayListToString(List<Integer> nums, int length) {
		if (length == 0) {
			return "[]";
		}

		String result = "";
		for (int index = 0; index < length; index++) {
			Integer number = nums.get(index);
			result += Integer.toString(number) + ", ";
		}
		return "[" + result.substring(0, result.length() - 2) + "]";
	}

	public static String integerArrayListToString(List<Integer> nums) {
		return integerArrayListToString(nums, nums.size());
	}

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String line;
		while ((line = in.readLine()) != null) {
			int[] arr = stringToIntegerArray(line);
			line = in.readLine();
			int k = Integer.parseInt(line);
			line = in.readLine();
			int x = Integer.parseInt(line);

			List<Integer> ret = new Solution().findClosestElements(arr, k, x);

			String out = integerArrayListToString(ret);

			System.out.print(out);
		}
	}
}
