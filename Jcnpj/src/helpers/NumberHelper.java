package helpers;

import com.google.common.base.CharMatcher;

public class NumberHelper {

	public static String getNumbers(String sequence) {
		return sequence == null ? "" : CharMatcher.DIGIT.retainFrom(sequence);
	}
}