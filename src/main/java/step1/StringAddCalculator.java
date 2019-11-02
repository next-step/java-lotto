package step1;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {
    public static final int CONTINUE = -1;
    private String input;

    public StringAddCalculator(String s) {
        this.input = s;
    }

    public int calculate() {
        int result = validate(this.input);
        if (result != CONTINUE) return result;

        result = calculateByCustomDelimiter();
        if (result != CONTINUE) return result;

        result = calculateByDefaultDelimiter();
        return result;
    }

    public int validate(String input) {
        if (isBlank(input)) {
            return 0;
        }

        if (isOneLengthNumber(input)) {
            return Integer.parseInt(input);
        }

        return CONTINUE;
    }

    public int calculateByCustomDelimiter() {
        // java.util.regex 패키지의 Matcher, Pattern import
        Matcher m = Pattern.compile("//(.)n(.*)").matcher(this.input);
        if (m.find()) {
            String customDelimiter = m.group(1);
            String[] tokens = m.group(2).split(customDelimiter);

            return plus(tokens);
        }
        return CONTINUE;
    }

    public int calculateByDefaultDelimiter() {
        String[] tokens= this.input.split(",|:");
        return plus(tokens);
    }

    public int plus(String[] operands) {
        int result = 0;

        for (String operand : operands) {
            int parsedOperand = Integer.parseInt(operand);

            if (!isNegative(parsedOperand)) {
                result += parsedOperand;
            }
        }
        return result;
    }

    public boolean isNegative(int operand) {
        if (operand < 0) {
            throw new RuntimeException("operand is negative");
        }

        return false;
    }

    private boolean isBlank(String text) {
        if (text == null || text.isEmpty()) {
            return true;
        }

        return false;
    }

    private boolean isOneLengthNumber(String text) {
        if (text.length() == 1 && isNumeric(text)) {
            return true;
        }

        return false;
    }

    private boolean isNumeric(String s) {
        try {
            Double.parseDouble(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}
