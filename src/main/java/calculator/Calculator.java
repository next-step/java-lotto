package calculator;

import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {
    public static final Pattern PERMIT_INPUT_REGEX = Pattern.compile("^[0-9+\\-*/ ]+$");
    public static final Pattern NUMBER_REGEX = Pattern.compile("^[0-9]+$");
    public static final Pattern SIGN_REGEX = Pattern.compile("^[+\\-*/]$");
    public static final String DEFAULT_DELIMITER = " ";

    public static int calculate(final String userInput) {
        isValidUserInput(userInput);
        final Tokens tokens = new Tokens(userInput.split(DEFAULT_DELIMITER));

        final Iterator<Token> tokenIterator = tokens.iterator();
        int result = tokenIterator.next().parseNumber();
        while (tokenIterator.hasNext()) {
            final Token signToken = tokenIterator.next();
            final Sign sign = signToken.sign();
            final Token operand = tokenIterator.next();
            result = sign.apply(result, operand.parseNumber());
        }

        return result;
    }

    private static void isValidUserInput(final String userInput) {
        if (isEmpty(userInput)) {
            throw new IllegalArgumentException("계산할 정보가 없습니다.");
        }

        final Matcher matcher = PERMIT_INPUT_REGEX.matcher(userInput);
        if (!matcher.find()) {
            throw new IllegalArgumentException("허용되지 않는 문자가 입력되었습니다.");
        }
    }

    private static boolean isEmpty(final String userInput) {
        return userInput == null || userInput.isEmpty();
    }
}
