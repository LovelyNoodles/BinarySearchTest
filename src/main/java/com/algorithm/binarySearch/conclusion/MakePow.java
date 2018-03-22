package com.algorithm.binarySearch.conclusion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;

public class MakePow {
	static class Solution {
		public double myPow(double x, int n) {
			Math.pow(0, 1);
			return n;
		}
	}

	public static String doubleToString(double input) {
		return new DecimalFormat("0.00000").format(input);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String line;
		while ((line = in.readLine()) != null) {
			double x = Double.parseDouble(line);
			line = in.readLine();
			int n = Integer.parseInt(line);

			double ret = new Solution().myPow(x, n);

			String out = doubleToString(ret);

			System.out.print(out);
		}
	}
}
