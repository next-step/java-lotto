package adder;

import static adder.CustomTokenizeStrategy.DELIMITER_PATTERN;

public class TokenizeStrategyFactory {

   public static TokenizeStrategy getTokenizeStrategy(Expression expression) {
        return containCustomDelimiter(expression)
                ? new CustomTokenizeStrategy()
                : new DefaultTokenizeStrategy();
    }

    private static boolean containCustomDelimiter(Expression expression) {
        return expression.getMatchers(DELIMITER_PATTERN)
                .matches();
    }
}
