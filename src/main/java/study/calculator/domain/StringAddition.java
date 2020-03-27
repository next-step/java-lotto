package study.calculator.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddition {
    private static final String[] DEFAULT_DELIMITERS = {",", ":"};

    public static int splitAndSum(String operandWithSeparator) {
        String customDelimiter =
                escapeRegExKeyword(findCustomDelimiter(operandWithSeparator));
        operandWithSeparator = operandWithSeparator.replaceAll("//.*\n", "");
        List<String> stringOperands =
                splitWithCustomDelimiter(splitWithDefaultDelimiter(operandWithSeparator), customDelimiter);

        List<Operand> operands = new ArrayList<>();
        for (String stringOperand : stringOperands) {
            if (stringOperand.isEmpty()) {
                operands.add(new Operand(0));
            } else {
                operands.add(new Operand(Integer.parseInt(stringOperand)));
            }
        }
        return Addition.sum(operands);
    }

    private static String[] splitWithDefaultDelimiter(String text) {
        String delimitersRegEx = String.join("|", DEFAULT_DELIMITERS);
        return text.split(delimitersRegEx);
    }

   private static List<String> splitWithCustomDelimiter(String[] stringOperands,
                                                    String customDelimiter) {
        List<String> operands = new ArrayList();
        for(String operand:stringOperands ) {
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
        if(keywords.contains(keyword)) {
            return "\\" + keyword;
        }
        return keyword;
    }
}
