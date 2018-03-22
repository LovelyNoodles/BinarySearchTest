package com.algorithm.binarySearch.templateIII;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SearchRange {

	static class Solution {
		public int[] searchRange(int[] nums, int target) {
			// return method1(nums, target);
			return method2(nums, target);
		}

		/**
		 * 左右边界法
		 * 
		 * @param nums
		 * @param target
		 * @return
		 */
		private int[] method2(int[] nums, int target) {
			int[] res = { -1, -1 };
			if (nums == null || nums.length == 0) {
				return res;
			}

			int l = 0;
			int r = nums.length - 1;
			while (l + 1 < r) {
				int m = l + ((r - l) >> 1);
				if (nums[m] < target) {
					l = m;
				} else {
					r = m;
				}
			}
			if (nums[l] == target) {
				res[0] = l;
			} else if (nums[r] == target) {
				res[0] = r;
			} else {
				return res;
			}

			l = 0;
			r = nums.length - 1;
			while (l + 1 < r) {
				int m = l + ((r - l) >> 1);
				if (nums[m] > target) {
					r = m;
				} else {
					l = m;
				}
			}
			if (nums[r] == target) {
				res[1] = r;
			} else if (nums[l] == target) {
				res[1] = l;
			} else {
				return res;
			}

			return res;
		}

		/**
		 * 一次循环法
		 * 
		 * @param nums
		 * @param target
		 * @return
		 */
		private int[] method1(int[] nums, int target) {
			if (nums == null || nums.length == 0) {
				return new int[] { -1, -1 };
			}
			if (nums.length == 1) {
				if (nums[0] == target) {
					return new int[] { 0, 0 };
				} else {
					return new int[] { -1, -1 };
				}
			}

			int l = 0;
			int r = nums.length - 1;
			while (nums[l] < nums[r]) {
				int m = l + ((r - l) >> 1);
				if (nums[m] == target) {
					if (nums[l] < target) {
						l++;
					}
					if (nums[r] > target) {
						r--;
					}
				} else if (nums[m] < target) {
					l = m + 1;
				} else {
					r = m - 1;
				}
			}
			if (nums[l] != target) {
				l = -1;
				r = -1;
			}

			return new int[] { l, r };
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

	public static String integerArrayToString(int[] nums, int length) {
		if (length == 0) {
			return "[]";
		}

		String result = "";
		for (int index = 0; index < length; index++) {
			int number = nums[index];
			result += Integer.toString(number) + ", ";
		}
		return "[" + result.substring(0, result.length() - 2) + "]";
	}

	public static String integerArrayToString(int[] nums) {
		return integerArrayToString(nums, nums.length);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String line;
		while ((line = in.readLine()) != null) {
			int[] nums = stringToIntegerArray(line);
			line = in.readLine();
			int target = Integer.parseInt(line);

			int[] ret = new Solution().searchRange(nums, target);

			String out = integerArrayToString(ret);

			System.out.print(out);
		}
	}
}
