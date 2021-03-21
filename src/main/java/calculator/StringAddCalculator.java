package calculator;

import common.utils.StringUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

    public int calculate(String text) {
        if(StringUtils.isBlank(text)) {
            return 0;
        }
        String[] calculateTarget = createCalculateTarget(text);
        return calculate(calculateTarget);
    }

    private String[] createCalculateTarget(String text) {
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(text);
        if (m.find()) {
            String customDelimiter = m.group(1);
            return m.group(2).split(customDelimiter);
        }
        return text.replace(':', ',').split(",");
    }

    private int calculate(String[] calculateTarget) {
        int sum = 0;
        for (String target : calculateTarget) {
            sum+=parseInt(target);
        }
        return sum;
    }

    private int parseInt(String target) {
        int targetNum;
        try {
            targetNum = Integer.parseInt(target);
        } catch (NumberFormatException e) {
            throw new RuntimeException();
        }
        if(targetNum<0) {
            throw new RuntimeException();
        }
        return Integer.parseInt(target);
    }
}
