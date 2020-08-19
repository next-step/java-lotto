package step1;

public class StringAddCalculator {

    public static int splitAndSum(String numericalExpression) {
        if (numericalExpression == null) {
            return 0;
        }
        if (numericalExpression.isEmpty()) {
            return 0;
        }
        String[] numbers = numericalExpression.split(",");
        if (numbers.length == 1) {
            return Integer.parseInt(numbers[0]);
        }
        int sumValue = Integer.parseInt(numbers[0]);
        for (int i = 1; i < numbers.length; i++) {
            sumValue += Integer.parseInt(numbers[i]);
        }
        return sumValue;
    }

}
