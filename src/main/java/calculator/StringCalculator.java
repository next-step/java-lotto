package calculator;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class StringCalculator {


    private final String calculatorSumString;
    private static final String DEFAULT_DELIMITER = ",|:";
    private final String delimeter;


    public StringCalculator(String calculatorSumString) {

        //널값
        if (calculatorSumString == null || calculatorSumString.equals("")) {
            calculatorSumString = "0";
        }
        //delimeter 구분
        delimeter = initDelimeter(calculatorSumString);

        if (!DEFAULT_DELIMITER.equals(delimeter)) {
            calculatorSumString = calculatorSumString.substring(calculatorSumString.indexOf("\n") + 1);
        }

        vaildCheck(calculatorSumString, delimeter);

        this.calculatorSumString = calculatorSumString;
    }

    private String initDelimeter(String calculatorSumString) {
        String delimeter  = StringCalculator.DEFAULT_DELIMITER;

        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(calculatorSumString);

        if (m.find()) {
            delimeter  = m.group(1);
        }

        return delimeter ;
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


