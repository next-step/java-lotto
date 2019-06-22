package StringAddCalculator;

public class StringAddCalculator {


    public static int add(String formula) {
        if(isNullOrEmpty(formula)) return 0;
        return addtionCalculate(formula);
    }

    private static boolean isNullOrEmpty(String input) {
        return input == null || input.isEmpty();
    }


    private static int addtionCalculate(String input) {
        String[] numbers = StringSplitter.split(input);
        StringNumbers stringNumbers = new StringNumbers(numbers);
        StringNumber resultNumber = stringNumbers.sum();
        return resultNumber.toInt();
    }
}
