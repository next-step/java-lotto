package lotto.domain;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Lotto {

    private static final String DELIMITER = ",";

    private final List<Integer> lotto;

    private Lotto(List<Integer> lotto) {
        this.lotto = Collections.unmodifiableList(lotto);
    }

    public static Lotto create() {
        return new Lotto(LottoGenerator.generate());
    }

    public static Lotto of(String s) {
        String[] numbers = Objects.requireNonNull(s).split(DELIMITER);
        validateNumbers(numbers);

        return new Lotto(Stream.of(numbers)
                .map(str -> Integer.parseInt(str.trim()))
                .collect(Collectors.toList()));
    }

    private static void validateNumbers(String[] numbers) {
        if (Stream.of(numbers).anyMatch(String::isBlank) || numbers.length != 6) {
            throw new IllegalArgumentException("6개 숫자를 입력하셔야 합니다.");
        }
    }

    public Stream<Integer> stream() {
        return lotto.stream();
    }

    @Override
    public String toString() {
        return lotto.toString();
    }
}
