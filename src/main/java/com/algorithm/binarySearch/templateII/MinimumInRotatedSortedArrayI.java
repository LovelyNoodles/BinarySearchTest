package com.algorithm.binarySearch.templateII;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @description 找出旋转有序数组最小值 [4, 5, 6, 7, 0, 1, 2], min : 0 [2, 0, 1]
 * @author Administrator
 */
public class MinimumInRotatedSortedArrayI {

	static class Solution {
		public int findMin(int[] nums) {
			if (nums == null || nums.length == 0) {
				return -1;
			}
			if (nums.length == 1) {
				return nums[0];
			}

			int l = 0;
			int r = nums.length - 1;
			if (nums[l] < nums[r]) {
				return nums[l];
			}
			while (l < r) {
				int m = l + ((r - l) >> 1);
				if (nums[m] < nums[r]) {
					r = m;
				} else {
					l = m + 1;
				}
			}
			return nums[l];
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

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String line;
		while ((line = in.readLine()) != null) {
			int[] nums = stringToIntegerArray(line);

			int ret = new Solution().findMin(nums);

			String out = String.valueOf(ret);

			System.out.print(out);
		}
	}
}
