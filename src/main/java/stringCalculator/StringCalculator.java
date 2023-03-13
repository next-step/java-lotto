package stringCalculator;

import java.util.Arrays;

public class StringCalculator {
    private String sumString;
    private int totalSum = 0;
    private String seperator;
    private String defaultSeperator = "[:,]";
    private String calculatorSeperator = "\n";
    private String checkSeperator = "//";
    private int[] numbers;


    public StringCalculator(String inputString) {
        sumString = inputString.replaceAll(" ", "");
    }

    public int parseString(String input) {
        String[] inputNumbers = input.split(seperator);
        for (String newNumber : inputNumbers)
            if (!checkNumber(newNumber))
                throw new RuntimeException("숫자 타입이 아닙니다");
        numbers = Arrays.stream(input.split(seperator)).mapToInt(Integer::parseInt).toArray();
        return numbers.length;
    }

    private boolean checkNumber(String number) {
        return number.matches("\\d+");
    }
    public int parseString2() {
        getSeperator();
        return parseString(sumString);
    }
    private void getSeperator () {
        String[] calculatorCheck = sumString.split(calculatorSeperator);
        if (calculatorCheck.length == 1) {
            seperator = defaultSeperator;
            return;
        }
        sumString = calculatorCheck[1].trim();
        if (calculatorCheck[0].substring(0,2).equals(checkSeperator))
            seperator = calculatorCheck[0].substring(2,3);
    }

    public int sum() {
        parseString2();
        for (int newNumber: numbers)
            totalSum += newNumber;
        return totalSum;
    }
}
