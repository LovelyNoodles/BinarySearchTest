package com.algorithm.binarySearch.conclusion;

public class SmallestLetter {
	static class Solution {
		public char nextGreatestLetter(char[] letters, char target) {

			int l = 0;
			int r = letters.length - 1;
			while (l + 1 < r) {
				int m = l + ((r - l) >> 1);
				if (letters[m] > target) {
					r = m;
				} else {
					l = m;
				}
			}

			return letters[l] > target || letters[r] < target + 1 ? letters[0] : letters[r];
		}
	}

	public static void main(String[] args) {
		char target = 'j';
		char[] letters = { 'c', 'f', 'j' };
		char c = new Solution().nextGreatestLetter(letters, target);
		System.out.println(c);
	}
}
