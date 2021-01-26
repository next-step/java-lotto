package calculator;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {



    public int add (String text) {
        int res = 0;
        if (InputValidator.checkIsNullOrIsEmpty(text)) {
            return 0;
        }

        if (text.length() == 1) {
          return Integer.parseInt(text);
        }

        res += splitByCustomDelimiter(text);
        res += splitByDelimiter(text);

        return res;
    }

    private int splitByDelimiter(String text) {
        String [] inputs = text.split(",|:");
        int res = Arrays.stream(inputs)
                .filter(input -> InputValidator.checkMinusParamInput(input))
                .map(Integer::parseInt)
                .reduce(Integer::sum).get();
//        for (String input : inputs) {
//            try {
//                InputValidator.checkMinusParamInput(input);
//            } catch (RuntimeException e) {
//                System.out.println("음수는 연산이 불가합니다.");
//            }
//            res += Integer.parseInt(input);
//        }
        return res;
    }

    private int splitByCustomDelimiter(String text) {
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(text);
        if (m.find()) {
            String customDelimiter = m.group(1);
            String[] tokens= m.group(2).split(customDelimiter);
            int res = 0;
            for (String input : tokens) {
                res += Integer.parseInt(input);
            }
            return res;
        }
        return 0;
    }

}
