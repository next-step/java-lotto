package calculator.delimiter;

import java.util.List;

public class CommaDelimiter implements Delimiter {
    private static final String DELIMITER = ",";

    @Override
    public List<String> split(List<String> expressions) {
        return this.splitByDelimiter(expressions, DELIMITER);
    }
}
