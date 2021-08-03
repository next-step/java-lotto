package adder;

import java.util.List;

public class DefaultTokenizeStrategy implements TokenizeStrategy {

    private static final String DELIMITER_PATTERN = ",|:";

    @Override
    public List<String> split(Expression expression) {
        return expression.split(DELIMITER_PATTERN);
    }
}
