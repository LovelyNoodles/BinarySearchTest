package com.algorithm.binarySearch.templateII;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FirstBadVersion {
	private int bad;

	public FirstBadVersion(int bad) {
		this.bad = bad;
	}

	boolean isBadVersion(int version) {
		return bad == version ? true : false;
	}

	// =============================================================
	public static class Solution extends FirstBadVersion {
		public Solution(int bad) {
			super(bad);
		}

		public int firstBadVersion(int n) {
			int old = 0;
			int fresh = n;
			while (old < fresh) {
				int mid = old + ((fresh - old) >> 1);
				if (isBadVersion(mid)) {
					fresh = mid;
				} else {
					old = mid + 1;
				}
			}
			return isBadVersion(old) ? old : -1;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String line;
		while ((line = in.readLine()) != null) {
			int n = Integer.parseInt(line);
			line = in.readLine();
			int bad = Integer.parseInt(line);

			int ret = new Solution(bad).firstBadVersion(n);

			String out = String.valueOf(ret);

			System.out.print(out);
		}
	}
}
