package stringcalculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {

    private String text;
    private String[] tokens;

    public StringCalculator() {

    }

    public void split() {
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(text);
        if (m.find()) {
            String customDelimiter = m.group(1);
            tokens = m.group(2).split(customDelimiter);
        } else {
            tokens = this.text.split(",|:");
        }

    }

    public int add(String text) {
        if (text == null || text.isEmpty()) {
            text = "0";
        }

        this.text = text;
        split();
        return operation();
    }


    public int operation() {
        int sum = 0;
        for (String t: tokens) {
            sum += getNumber(t);
        }
        return sum;
    }

    public int getNumber(final String text) {
        if(Integer.parseInt(text) < 0) {
            throw new RuntimeException("음수");
        }
        return Integer.parseInt(text);
    }
}
