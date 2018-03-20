package com.algorithm.binarySearch.templateI;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class GetSqrt {
	static class Solution {
		public int mySqrt(int x) {

			if (x == 0) {
				return 0;
			}

			int left = 1;
			int right = x;
			// int mid = 1;
			while (true) {
				// 当(right + left)超出int表示范围时，其结果会有问题
				// int mid = (right + left) / 2;
				int mid = left + (right - left) / 2;
				if (mid > x / mid) {
					right = mid - 1;
				} else {
					if (mid + 1 > x / (mid + 1))
						return mid;
					left = mid + 1;
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String line;
		while ((line = in.readLine()) != null) {
			int x = Integer.parseInt(line);

			int ret = new Solution().mySqrt(x);

			String out = String.valueOf(ret);

			System.out.print(out);
		}
	}
}
