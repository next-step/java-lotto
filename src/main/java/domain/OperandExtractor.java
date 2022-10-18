package domain;

import java.util.Deque;
import java.util.LinkedList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class OperandExtractor implements Extractor<Long> {
    private static final Pattern OPERAND_PATTERN = Pattern.compile("[0-9]");

    private OperandExtractor() {}

    public static OperandExtractor getInstance() {
        return LazyHolder.instance;
    }

    private static class LazyHolder {
        private static final OperandExtractor instance = new OperandExtractor();
    }

    @Override
    public Deque<Long> extractToDeque(String text) {
        Deque<Long> operandDeque = new LinkedList<>();
        Matcher matcher = OPERAND_PATTERN.matcher(text);

        while (matcher.find()) {
            operandDeque.add(Long.parseLong(matcher.group()));
        }

        return operandDeque;
    }
}
