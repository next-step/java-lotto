package study.step1.domain;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {
    private final List<String> stringNumberList;
    private int sum = 0;

    public Calculator(String input) {
        stringNumberList = Arrays.asList(splitInput(input));
    }

    private String[] splitInput(String input) {
        String separator = ",|:";
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(input);
        if (m.find()) {
            separator = m.group(1);
            return m.group(2).split(separator);
        }
        return input.split(separator);
    }

    public int sum() {
        stringNumberList.forEach(str -> {
            try {
                int num = Integer.parseInt(str);
                if(num < 0) {
                    throw new RuntimeException();
                }
                sum += num;
            } catch(RuntimeException e) {
                throw new RuntimeException("잘못된 입력값입니다.");
            }
        });

        return sum;
    }

}
