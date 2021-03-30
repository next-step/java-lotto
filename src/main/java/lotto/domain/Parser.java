package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Parser {
    public static List<Integer> parse(List<String> inputStrings) {
        return inputStrings.stream()
                .map(v -> Integer.parseInt(v))
                .collect(Collectors.toList());
    }
    
}
