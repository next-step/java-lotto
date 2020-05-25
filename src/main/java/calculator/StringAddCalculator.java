package calculator;


import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

    public int splitAndSum(String input) {
        if (isNullOrEmpty(input)) {
            return 0;
        }
        return getSum(getSplitString(input));
    }

    private void negativeOrNotNumberCheck(String input) {
        if (input.matches("-[0-9]*|[\\D]*")) {
            throw new IllegalArgumentException("음수를 제외한 숫자 외 다른 문자를 입력할 수 없습니다.");
        }
    }

    private String[] getSplitString(String input) {
        negativeOrNotNumberCheck(input);
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(input);
        System.out.println(input);
//        System.out.println(m.find());
        if (m.find()) {
            String customDelimiter = m.group(1);
            System.out.println("customDelimiter : " + customDelimiter);
            System.out.println("input : " + m.group(2));
            System.out.println("split : " + Arrays.toString(m.group(2).split(customDelimiter)));
            return m.group(2).split(customDelimiter);
        }
        return input.split("[,:]");
    }

    private boolean isNullOrEmpty(String input) {
        return input == null || input.replaceAll(" ", "").isEmpty();
    }

    private int getSum(String[] numbers) {
        int sum = 0;

        for (String number : numbers) {
            sum += Integer.parseInt(number);
        }
        return sum;
    }
}
