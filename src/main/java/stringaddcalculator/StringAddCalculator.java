package stringaddcalculator;

public class StringAddCalculator {

	public static Integer sum(String value) {
		return PositiveNumberExtractor.create(value).stream()
			.mapToInt(PositiveNumber::getNumber)
			.sum();
	}
}
