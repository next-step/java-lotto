package step3.util;

public class NumberUtil {

	private NumberUtil() {}

	public static boolean isInRange(Integer source, Integer minTarget, Integer maxTarget) {
		return source.compareTo(minTarget) >= 0 && source.compareTo(maxTarget) <= 0;
	}
}
