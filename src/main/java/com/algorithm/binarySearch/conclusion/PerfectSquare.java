package com.algorithm.binarySearch.conclusion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 求num是否为完全平方 注意：用减法代替加法，用除法代替乘法(但在Java里有时除法的结果并不一定等于乘法)
 * 
 * @description
 * @author Administrator
 */
public class PerfectSquare {
	static class Solution {
		public boolean isPerfectSquare(int num) {
			int l = 1;
			int r = num;
			while (l < r) {
				int m = l + ((r - l) >> 1);
				// Prevent (m * m) overflow
				if (m < num / m) {
					l = m + 1;
				} else {
					r = m;
				}
			}
			return l * l == num;
		}
	}

	public static String booleanToString(boolean input) {
		return input ? "True" : "False";
	}

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String line;
		while ((line = in.readLine()) != null) {
			int num = Integer.parseInt(line);

			boolean ret = new Solution().isPerfectSquare(num);

			String out = booleanToString(ret);

			System.out.print(out);
		}
	}
}
