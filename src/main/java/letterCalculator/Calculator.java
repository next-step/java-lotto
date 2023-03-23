package letterCalculator;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {

    private static String inputString;
    private static final String DEFAULT_SEPARATOR = ",|:";

    public Calculator(String inputString) {
        this.inputString = inputString;
    }

    public static void main(String args) {
        //입력값
        String Input = args;
        calculator();

    }

    public static int calculator() {
        int ResultNumber = 0;
        /* 빈입력값인지 체크 */
        if (returnZero() == 0) {
            return 0;
        }
        /*  구분자나누기 */
        String[] numbers = separatorFuntion();

        Arrays.stream(numbers).forEach(actual -> {
            actualValidate(actual);
        });

        negativeInputNumberCheck(numbers);

        ResultNumber = addNumbers(numbers);
        System.out.println(ResultNumber);
        return ResultNumber;
    }

    public static int returnZero() {
        if (inputString == null || inputString.isBlank()) {
            System.out.println("[" + inputString + "]");
            return 0;
        }
        return -1;
    }

    public int calcSum() {
        return 0;
    }


    private static int addNumbers(String[] numbers) {
        int result;
        result = Integer.parseInt(numbers[0]);
        for (int i = 1; i < numbers.length; i++) {
            result = result + Integer.parseInt(numbers[i]);
        }

        return result;
    }

    public static void negativeInputNumberCheck(String[] Input){
        for (String s : Input) {
            if (Integer.parseInt(s.toString()) < 0) {
                throw new RuntimeException("음수는 입력할 수 없습니다.");
            }
        }
    }

    public static void actualValidate(String Input) {
        if (!(Input.matches("\\d*") || Input.matches("[:,]"))) {
            throw new IllegalArgumentException("구분자 외의 문자열 입력되었습니다." + "[ " + Input + " ]");
        }
    }

    /* 구분자나누기 */
    public static String[] separatorFuntion() {
        Matcher pattern = Pattern.compile("//(.)\n(.*)").matcher(inputString);
        if (pattern.find()) {
            return pattern.group(2).split(pattern.group(1));
        }
        return inputString.split(DEFAULT_SEPARATOR);
    }

}
