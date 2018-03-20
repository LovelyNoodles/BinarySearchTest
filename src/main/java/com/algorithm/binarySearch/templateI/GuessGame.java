package com.algorithm.binarySearch.templateI;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class GuessGame {

	private static int pick = 0;

	@SuppressWarnings("static-access")
	public GuessGame(int pick) {
		this.pick = pick;
	}

	private static int guess(int m) {
		if (pick > m) {
			return 1;
		} else if (pick < m) {
			return -1;
		} else {
			return 0;
		}
	}

	public static class Solution extends GuessGame {
		public Solution(int pick) {
			super(pick);
		}

		public int guessNumber(int n) {
			int l = 0;
			int r = n;
			while (l <= r) {
				int m = l + ((r - l) >> 1);
				if (guess(m) == -1) {
					r = m - 1;
				} else if (guess(m) == 1) {
					l = m + 1;
				} else {
					return m;
				}
			}
			return -1;
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String line;
		while ((line = in.readLine()) != null) {
			int n = Integer.parseInt(line);
			line = in.readLine();
			int pick = Integer.parseInt(line);

			int ret = new Solution(pick).guessNumber(n);

			String out = String.valueOf(ret);

			System.out.print(out);
		}
	}
}
