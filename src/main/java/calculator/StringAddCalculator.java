package calculator;

public class StringAddCalculator {

    private static String delimeter = ",";

    public static int splitAndSum(String calculationText) {

        if (validate(calculationText)) {
            return 0;
        }
        return calculate(calculationText);
    }

    private static boolean validate(String calculationText) {
        return calculationText == null || calculationText.isEmpty();
    }

    private static int calculate(String calculationText) {

        String[] numbers = calculationTextSplit(calculationText);
        int calculationNumber = 0;

        if (numbers.length == 1) {
            return Integer.parseInt(numbers[0]);
        }
        for(String number : numbers) {
            calculationNumber += Integer.parseInt(number);
        }

        return calculationNumber;
    }

    private static String[] calculationTextSplit(String calculationText) {
        return calculationText.split(",");
    }

}
