package stringaddcalculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Number {
    public static final int ZERO = 0;
    private int value;

    public Number(int value) {
        this.value = value;
        checkValidation(value);
    }

    private void checkValidation(int value) {
        Pattern p = Pattern.compile("(^[0-9]*$)");
        Matcher matcher = p.matcher(Integer.toString(value));

        if(!matcher.find()) {
            throw new RuntimeException();
        }
    }

    public int sumValue(String[] inputs) {
        int sum = 0;

        for (String singleInput : inputs) {
            sum += Integer.parseInt(singleInput);
        }
        return sum;
    }
}
