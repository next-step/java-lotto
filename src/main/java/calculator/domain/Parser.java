package calculator.domain;

import java.util.ArrayList;
import java.util.List;

public class Parser {

    private static final String NEW_LINE = "\n";
    private static final String DOUBLE_SLASH = "//";
    private static final String START_REGEX = "[";
    private static final String END_REGEX = "]";

    private static final int DELIMITER_PART_INDEX = 1;

    private final String operation;
    private final List<String> delimiters;

    public Parser(String text, List<String> delimiters) {
        this.operation = trimDelimiter(text);
        this.delimiters = new ArrayList<>(delimiters);
    }

    private String trimDelimiter(String text) {
        if (isCustomDelimiter(text)) {
            return text.split(NEW_LINE)[DELIMITER_PART_INDEX];
        }
        return text;
    }

    private boolean isCustomDelimiter(String text) {
        return text.startsWith(DOUBLE_SLASH);
    }

    public String[] parseOperands() {
        final String regex = makeRegularExpression();
        validateEndByDelimiter(regex);
        return operation.split(regex);
    }

    private void validateEndByDelimiter(String regex) {
        final String endOfOperation = operation.substring(operation.length() - 1);
        if (endOfOperation.matches(regex)) {
            throw new RuntimeException("[ERROR] 숫자 이외의 값을 계산할 수 없습니다.");
        }
    }

    private String makeRegularExpression() {
        String regex = String.join("", delimiters);
        return START_REGEX + regex + END_REGEX;
    }
}
