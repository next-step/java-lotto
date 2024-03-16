package calculator;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import static java.util.Objects.nonNull;

public class Validator {
    private static final Pattern PATTERN_FOR_POSITIVE_INTEGER = Pattern.compile("^(0*[1-9][0-9]*)$");
    private static final String BLANK = " ";
    private static final int MIN_TOKEN_NUM = 3;

    public static boolean hasBlankBetweenNumberAndOperand(String input) {
        String[] tokens = input.split(BLANK);
        List<Boolean> validationResultList = new ArrayList<>();

        for(int i = 0; i < tokens.length; i++) {
            validationResultList.add(isValidToken(i, tokens[i]));
        }

        if(validationResultList.contains(false)) {
            return false;
        }

        return true;
    }

    private static boolean isValidToken(int i, String token) {
        if (i % 2 == 0 && !PATTERN_FOR_POSITIVE_INTEGER.matcher(token).find()) {
            return false;
        }

        if (i % 2 != 0 && !(token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/"))) {
            return false;
        }

        return true;
    }

    public static boolean isNonBlankInput(String input) {
        return nonNull(input) && !input.isBlank();
    }

    public static boolean minNumberOfTokens(String input) {
        return input.split(BLANK).length >= MIN_TOKEN_NUM;
    }

    public static boolean isValidStartAndLastNumber(String input) {
        char[] tokens = input.toCharArray();

        if (!PATTERN_FOR_POSITIVE_INTEGER.matcher(String.valueOf(tokens[0])).find()) {
            return false;
        }

        if (!PATTERN_FOR_POSITIVE_INTEGER.matcher(String.valueOf(tokens[tokens.length - 1])).find()) {
            return false;
        }
        return true;
    }
}
