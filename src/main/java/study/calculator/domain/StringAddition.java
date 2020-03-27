package study.calculator.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddition {
    private static final String[] DEFAULT_DELIMITERS = {",", ":"};

    public static int splitAndSum(String operandWithSeparator) {
        if(Objects.isNull(operandWithSeparator)) {
            return 0;
        }
        String customDelimiter =
                escapeRegExKeyword(findCustomDelimiter(operandWithSeparator));
        operandWithSeparator = operandWithSeparator.replaceAll("//.*\n", "");
        List<String> stringOperands =
                splitWithDefaultDelimiter(operandWithSeparator);
        if (!Objects.isNull(customDelimiter)) {
            stringOperands = splitWithCustomDelimiter(stringOperands,
                    customDelimiter);
        }

        List<Operand> operands = new ArrayList<>();
        for (String stringOperand : stringOperands) {
            operands.add(Operand.getInstance(stringOperand));
        }
        return Addition.sum(operands);
    }

    private static List<String> splitWithDefaultDelimiter(String text) {
        String delimitersRegEx = String.join("|", DEFAULT_DELIMITERS);
        return Arrays.asList(text.split(delimitersRegEx));
    }

    private static List<String> splitWithCustomDelimiter(
            List<String> stringOperands,
            String customDelimiter) {
        List<String> operands = new ArrayList();
        for (String operand : stringOperands) {
            operands.addAll(Arrays.asList(operand.split(customDelimiter)));
        }

        return operands;
    }

    private static String findCustomDelimiter(String text) {
        Matcher m =
                Pattern.compile("//(?<delimiter>.*)\n").matcher(text);
        if (m.find()) {
            String customDelimiter = m.group("delimiter");
            return customDelimiter;
        }

        return null;
    }

    private static String escapeRegExKeyword(String keyword) {
        List<String> keywords = Arrays.asList("?", "*", "+", "(", ")", "[",
                "]", "{", "}");
        if (keywords.contains(keyword)) {
            return "\\" + keyword;
        }
        return keyword;
    }
}
