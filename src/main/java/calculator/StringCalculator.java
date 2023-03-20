package calculator;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class StringCalculator {


    private final String calculatorSumString;
    private static final String default_delimeter = ",|:";
    private final String delimeter;


    public StringCalculator(String calculatorSumString) {

        //널값
        if (calculatorSumString == null || calculatorSumString.equals("")) {
            calculatorSumString = "0";
        }
        //delimeter 구분
        delimeter = initDelimeter(calculatorSumString);

        if (!default_delimeter.equals(delimeter)) {
            calculatorSumString = calculatorSumString.substring(calculatorSumString.indexOf("\n") + 1);
        }

        vaildCheck(calculatorSumString, delimeter);

        this.calculatorSumString = calculatorSumString;
    }

    public String initDelimeter(String calculatorSumString) {
        String defaultDelimeter = StringCalculator.default_delimeter;

        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(calculatorSumString);

        if (m.find()) {
            defaultDelimeter = m.group(1);
        }

        return defaultDelimeter;
    }

    public void vaildCheck(String calculatorSumString, String delimeter) {

        if (calculatorSumString == null || calculatorSumString.equals("")) {
            return;
        }

        String tmpCalculatorSumString = calculatorSumString.replaceAll(delimeter, "").replace(" ", "");


        if (!tmpCalculatorSumString.matches("\\d+")) {
            throw new IllegalArgumentException("정의되지않은 값이 들어감");
        }
    }

    public String getCalculatorSumString() {
        return calculatorSumString;
    }

    public List<Integer> getSplitCalculatorNumbers() {

        String[] array = calculatorSumString.split(delimeter);

        return Arrays.stream(array).map(Integer::valueOf).collect(Collectors.toList());
    }

    public String getDelimeter() {
        return delimeter;
    }

    public Integer getSum() {
        List<Integer> numbers = getSplitCalculatorNumbers();
        return numbers.stream().mapToInt(i -> i).sum();
    }
}


