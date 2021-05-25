package nl.gerete.util;

/**
 * @author <a href="mailto:marc.mol@bloomville.nl">Marc Mol</a>
 * Created on 03-05-2021.
 */
public class LongestSubstring {

	public int lengthOfLongestSubstring(String s) {

		if (s.length() == 0) {
			return 0;
		}
		int answer = 0;
		int higest = 1;
		for (int i = 0; i< s.length();i++) {
			int k = 0;
			char[] chars = new char[Math.min(s.length(), 100)];
			for (char c : s.substring(i).toCharArray()) {
				if (isInArray(chars, c)) {
					if (answer > higest) {
						higest = answer;
						if (higest == 95) {
							return 95;
						}
					}
					answer = 0;
					break;
				}
				answer++;
				chars[k++] = c;
			}
			if(k == s.length() - i) {
				if(answer > higest) {
					higest = answer;
				}
			}
			answer = 0;
		}
		return higest;
	}

	private boolean isInArray(char[] chars, char c) {
		for (char ch: chars) {
			if (ch == c) {
				return true;
			}
		}
		return false;
	}
}
