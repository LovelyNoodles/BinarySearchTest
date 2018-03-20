package com.algorithm.binarySearch.templateI;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RotatedSortedArrayI {

	static class Solution {
		public int search(int[] nums, int target) {
			int n = nums.length;
			if (n == 0)
				return -1;
			int left = 0, right = n - 1;
			while (left <= right) {
				int mid = (left + right) / 2;
				if (nums[mid] == target)
					return mid;
				else if (nums[mid] < nums[right]) {
					if (nums[mid] < target && nums[right] >= target)
						left = mid + 1;
					else
						right = mid - 1;
				} else {
					if (nums[left] <= target && nums[mid] > target)
						right = mid - 1;
					else
						left = mid + 1;
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
