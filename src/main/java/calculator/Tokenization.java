package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Tokenization {

    private static final String TOKEN_DELIMITER = ",|:";
    private static final String REG_EXP = "//(.)\n(.*)";
    private static final int DELIMITER_GROUP_NUMBER = 1;
    private static final int EXPRESSION_GROUP_NUMBER = 2;

    public String[] splitedExpression(String expression) {
        Matcher matcher = Pattern.compile(REG_EXP).matcher(expression);
        String delimiter = TOKEN_DELIMITER;

        if (matcher.find()) {
            delimiter = matcher.group(DELIMITER_GROUP_NUMBER);
            expression = matcher.group(EXPRESSION_GROUP_NUMBER);
        }

        return expression.split(delimiter);
    }

}
