package step3.util;

public class NumberUtil {

	public static boolean isOver(Integer source, Integer target) {
		return source.compareTo(target) > 0;
	}

	public static boolean isUnder(Integer source, Integer target) {
		return source.compareTo(target) < 0;
	}
}
