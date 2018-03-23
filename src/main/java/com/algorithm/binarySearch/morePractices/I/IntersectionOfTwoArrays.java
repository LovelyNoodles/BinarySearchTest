package com.algorithm.binarySearch.morePractices.I;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.BitSet;

public class IntersectionOfTwoArrays {
	static class Solution {
		public int[] intersection(int[] nums1, int[] nums2) {

			BitSet bitset1 = new BitSet(nums1.length);
			for (int i = 0; i < nums1.length; i++) {
				bitset1.set(nums1[i]);
			}

			BitSet bitset2 = new BitSet(nums2.length);
			for (int i = 0; i < nums2.length; i++) {
				bitset2.set(nums2[i]);
			}

			bitset1.and(bitset2);

			int i = 0;
			int index = 0;
			int[] result = new int[bitset1.cardinality()];
			while (true) {
				i = bitset1.nextSetBit(i);
				if (i == -1) {
					break;
				}
				result[index++] = i++;
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
			int[] nums1 = stringToIntegerArray(line);
			line = in.readLine();
			int[] nums2 = stringToIntegerArray(line);

			int[] ret = new Solution().intersection(nums1, nums2);

			String out = integerArrayToString(ret);

			System.out.print(out);
		}
	}
}
