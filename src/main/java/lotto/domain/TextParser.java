package lotto.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public final class TextParser {

    public static final String TEXT_SEPARATOR = ",";
    private final List<Integer> parsed;

    public TextParser(final String text) {
        validateBlank(text);
        parsed = toInts(text);
    }

    private void validateBlank(final String value) {
        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException("값을 입력해야 합니다");
        }
    }

    private List<Integer> toInts(final String text) {
        String[] parsed = text.split(TEXT_SEPARATOR);
        return Arrays.stream(parsed)
            .map(s -> Integer.parseInt(s.trim()))
            .collect(Collectors.toUnmodifiableList());
    }

    public List<Integer> getParsed() {
        return List.copyOf(parsed);
    }

}
