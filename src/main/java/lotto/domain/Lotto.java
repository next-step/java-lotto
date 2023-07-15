package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lotto {
    private static final int LOTTO_SIZE = 6;
    private static final List<LottoNumber> values = IntStream.rangeClosed(LottoNumber.LOTTO_START, LottoNumber.LOTTO_END)
            .boxed()
            .map(LottoNumber::of)
            .collect(Collectors.toList());

    private final List<LottoNumber> numbers;

    private Lotto(final List<LottoNumber> numbers) {
        numbers.sort(Comparator.comparing(LottoNumber::getNumber));
        this.numbers = Collections.unmodifiableList(numbers);
    }

    public static Lotto createAutomaticLotto() {
        Collections.shuffle(values);
        return new Lotto(new ArrayList<>(values.subList(0, LOTTO_SIZE)));
    }

    public static Lotto createManualLotto(final List<Integer> numbers) {
        verifySize(numbers);
        verifyDuplicate(numbers);

        return new Lotto(
                numbers.stream()
                        .map(LottoNumber::of)
                        .collect(Collectors.toList())
        );
    }

    private static void verifyDuplicate(final List<Integer> numbers) {
        if (numbers.stream().distinct().count() != LOTTO_SIZE) {
            throw new IllegalArgumentException("lotto can't contain same numbers");
        }
    }

    private static void verifySize(final List<Integer> numbers) {
        if (numbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException("lotto size must be 6");
        }
    }

    public long countMatches(final Lotto other) {
        return this.numbers.stream()
                .filter(other.numbers::contains)
                .count();
    }

    public List<LottoNumber> getLottoNumbers() {
        return this.numbers;
    }

    public boolean contains(LottoNumber number) {
        return this.numbers.contains(number);
    }
}