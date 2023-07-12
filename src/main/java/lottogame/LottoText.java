package lottogame;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public final class LottoText {

    private final List<Integer> parsed;

    public LottoText(final String text) {
        validateBlank(text);
        parsed = convertToInt(text);
    }

    private void validateBlank(final String value) {
        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException("숫자를 입력해야 합니다");
        }
    }

    private List<Integer> convertToInt(final String text) {
        String[] parsed = text.split(",");
        return Arrays.stream(parsed)
            .map(s -> Integer.parseInt(s.trim()))
            .collect(Collectors.toUnmodifiableList());
    }

    public List<Integer> getParsed() {
        return List.copyOf(parsed);
    }

}
