package utils;

public class NumberUtils {

	public static double mathRound(final double source, final double target, final DecimalType decimalType){
		if(target == 0.0) return 0.0;
		double result = source / target;
		double decimalNumber = decimalType.value();
		return Math.round(result * decimalNumber) / decimalNumber;
	}
}
