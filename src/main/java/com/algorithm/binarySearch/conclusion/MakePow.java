package com.algorithm.binarySearch.conclusion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;

/**
 * @description 求x^n
 * 
 *              分析：
 *              一、x^16 = (x^8)^2 = ((x^4)^2)^2 = (((x^2)^2)^2)^2
 *              
 *              n 	:	16		8			4					2				1
 *              res	:	1		1			1					1				1*(...)
 *              x	:	x^2	   (x^2)^2	   ((x^2)^2)^2		(((x^2)^2)^2)^2	   (...)^2
 *              
 *              二、x^18 = (x^9)^2 = ((x^8)x)^2 = (((x^4)^2)x)^2 = ((((x^2)^2)^2)x)^2=x^2((((x^2)^2)^2))^2
 *           	    x^18 = (x^9)^2 = ((x^8)x)^2 = (((x^4)^2)x)^2 =x^2(((x^4)^2))^2 = x^2((((x^2)^2)^2))^2
 *              n	:	18		9			4					2				1
 *              res	:	1		x^2			x^2					x^2				(x^2)(((x^2)^2)^2)^2	
 *              x	:	x^2	   (x^2)^2	   ((x^2)^2)^2		(((x^2)^2)^2)^2	   (...)^2
 *              
 *              三、(a*b)^n = a^2*b^2
 * @author Administrator
 */
public class MakePow {
	static class Solution {
		public double myPow(double x, int n) {
			double res = 1.0;
			for (int i = n; i != 0; i /= 2) {
				if (i % 2 != 0) {
					res *= x;
				}
				if (i > 1 || i < -1) {
					x *= x;
				}
			}
			return n < 0 ? 1 / res : res;
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

			System.out.println(out);
			System.out.println(Math.pow(x, n));
		}
	}
}
