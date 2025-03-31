package lotto.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Parser {
    public List<Integer> splitAndParseToIntegerList(String input) {
        try {
            return List.copyOf(Arrays.stream(input.trim().split(","))
                    .map(token -> Integer.parseInt(token.trim()))
                    .collect(Collectors.toList()));
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("입력값은 정수여야 합니다.");
        }
    }
}
