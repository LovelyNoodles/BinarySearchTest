package com.algorithm.binarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MyBinarySearch {

	static class Solution {
		public int search(int[] nums, int target) {

			if (nums == null || nums.length == 0) {
				return -1;
			}
			if (nums.length == 1 && nums[0] == target) {
				return 0;
			}

			int l = 0;
			int r = nums.length - 1;
			int m = 0;
			while (l <= r) {
				m = (l + r) >> 1;
				int comp = nums[m];
				if (target < comp) {
					r = m - 1;
				} else if (target > comp) {
					l = m + 1;
				} else {
					return m;
				}
			}
			return -1;
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
			line = in.readLine();
			int target = Integer.parseInt(line);

			int ret = new Solution().search(nums, target);

			String out = String.valueOf(ret);

			System.out.print(out);
		}
	}
}
