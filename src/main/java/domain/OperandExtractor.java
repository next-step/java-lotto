package domain;

import java.util.Deque;
import java.util.LinkedList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class OperandExtractor implements Extractor<Integer> {
    private static final Pattern OPERAND_PATTERN = Pattern.compile("[0-9]");

    private OperandExtractor() {}

    public static OperandExtractor getInstance() {
        return LazyHolder.instance;
    }

    private static class LazyHolder {
        private static final OperandExtractor instance = new OperandExtractor();
    }

    @Override
    public Deque<Integer> extractToDeque(String text) {
        Deque<Integer> operandDeque = new LinkedList<>();
        Matcher matcher = OPERAND_PATTERN.matcher(text);

        while (matcher.find()) {
            operandDeque.add(Integer.parseInt(matcher.group()));
        }

        return operandDeque;
    }
}
