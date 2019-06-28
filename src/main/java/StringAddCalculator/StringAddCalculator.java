package StringAddCalculator;

public class StringAddCalculator {

    private final static int CALCULATOR_DEFAULT_VALUE = 0;

    public static int add(String formula) {
        if(isNullOrEmpty(formula)) {
            return CALCULATOR_DEFAULT_VALUE;
        }
        return additionCalculate(formula);
    }

    private static boolean isNullOrEmpty(String input) {
        return input == null || input.isEmpty();
    }

    private static int additionCalculate(String input) {
        StringNumbers stringNumbers = new StringNumbers(StringSplitter.split(input));
        StringNumber resultNumber = stringNumbers.sum();
        return resultNumber.toInt();
//        return new StringNumbers(StringSplitter.split(input)).sum().toInt(); << 이렇게도 가능 할 듯.
    }
}
