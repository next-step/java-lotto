package utils;

public class ValidationUtils {
	public static int checkNegativeValue(int targetValue) {
		if(targetValue < 0) {
			throw new RuntimeException("음수가 입력되었습니다. [" + targetValue + "]");
		}
		return targetValue;
	}
}
