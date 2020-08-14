import org.apache.commons.lang3.StringUtils;

import java.util.regex.Pattern;

public class ExpressionValidator {
    private static final String EXPRESSION_PATTERN = "^([\\/]{2}.\\n)*([0-9])(.[0-9])*$";

    public static boolean validExpression(String expressionValue) {
        if (StringUtils.isBlank(expressionValue)) {
            return false;
        }

        return Pattern.matches(EXPRESSION_PATTERN, expressionValue);
    }
}
