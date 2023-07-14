package lotto.domain.game;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.OptionalInt;
import java.util.stream.Collectors;

public final class LottoText {

    private final List<Integer> integers;

    public LottoText(final String text) {
        integers = toIntegers(text);
    }

    private List<Integer> toIntegers(final String text) {
        String[] values = text.split(",");
        return Arrays.stream(values)
            .map(value -> OptionalInt.of(Integer.parseInt(value.trim()))
                .orElseThrow(() -> new NumberFormatException("숫자를 입력해 주세요")))
            .collect(Collectors.toUnmodifiableList());
    }

    public List<Integer> getIntegers() {
        return Collections.unmodifiableList(integers);
    }

}
