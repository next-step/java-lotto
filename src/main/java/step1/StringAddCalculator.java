package step1;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class StringAddCalculator {
    static private final Pattern p = Pattern.compile("//(.)\n(.*)");

    static public int splitAndSum(String text) {
        if (text == null || text.isEmpty()) {
            return 0;
        }

        List<Integer> tokens = split(text);
        validateTokens(tokens);
        return sum(tokens);
    }

    static private List<Integer> split(String text) {
        Matcher m = p.matcher(text);

        if (m.find()) {
            String customDelimiter = m.group(1);
            return Arrays.stream(m.group(2)
                .split(customDelimiter))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        }

        return Arrays.stream(text.split("[,:]"))
            .map(Integer::parseInt)
            .collect(Collectors.toList());
    }

    static private int sum(List<Integer> tokens) {
        return tokens.stream()
            .reduce(Integer::sum)
            .get();
    }

    static private void validateTokens(List<Integer> tokens) {
        if (tokens.stream().anyMatch(StringAddCalculator::isNegative)) {
            throw new RuntimeException("입력값으로 음수가 들어왔습니다.");
        }
    }

    static private boolean isNegative(int i) {
        return i < 0;
    }
}
