package com.algorithm.binarySearch.templateII;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @description 找出数组的峰值 [1, 2, 3, 1],峰值: 3
 * @author Administrator
 */
public class PeakElement {

	static class Solution {
		public int findPeakElement(int[] nums) {

			if (nums == null || nums.length == 0) {
				return -1;
			}
			if (nums.length == 1) {
				return 0;
			}

			int left = 0;
			int right = nums.length;
			while (left < right) {
				int mid = left + ((right - left) >> 1);
				if (nums[mid] < nums[mid + 1 < nums.length - 1 ? mid + 1 : nums.length - 1]) {
					left = mid + 1;
				} else {
					right = mid;
				}
			}

			return left != nums.length ? left : -1;
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

			int ret = new Solution().findPeakElement(nums);

			String out = String.valueOf(ret);

			System.out.print(out);
		}
	}
}
