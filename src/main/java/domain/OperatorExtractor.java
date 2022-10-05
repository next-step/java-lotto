package domain;

import java.util.Deque;
import java.util.LinkedList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class OperatorExtractor implements Extractor<String>{
    private static final Pattern OPERATOR_PATTERN = Pattern.compile("[+*-/]");

    private OperatorExtractor() {}

    public static OperatorExtractor getInstance() {
        return LazyHolder.instance;
    }

    private static class LazyHolder {
        private static final OperatorExtractor instance = new OperatorExtractor();
    }

    @Override
    public Deque<String> extractToDeque(String text) {
        Deque<String> operatorQueue = new LinkedList<>();
        Matcher matcher = OPERATOR_PATTERN.matcher(text);

        while (matcher.find()) {
            operatorQueue.add(matcher.group());
        }

        return operatorQueue;
    }
}
