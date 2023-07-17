package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import lotto.domain.vo.LottoNumber;

public class Lotto {

    private static final int LOTTO_SIZE = 6;
    private static final List<LottoNumber> values = IntStream.rangeClosed(
            LottoNumber.LOTTO_START,
            LottoNumber.LOTTO_END
        )
        .mapToObj(LottoNumber::of)
        .collect(Collectors.toList());

    private final List<LottoNumber> numbers;

    private Lotto(final List<LottoNumber> numbers) {
        this.numbers = Collections.unmodifiableList(numbers);
    }

    public static Lotto createRandomLotto() {
        Collections.shuffle(values);
        return new Lotto(new ArrayList<>(values.subList(0, LOTTO_SIZE)));
    }

    public static Lotto createSpecificLotto(final List<Integer> numbers) {
        verifySize(numbers);
        verifyDuplicate(numbers);

        List<LottoNumber> lottoNumbers = numbers.stream()
            .map(LottoNumber::of)
            .collect(Collectors.toList());
        return new Lotto(lottoNumbers);
    }

    private static void verifyDuplicate(final List<Integer> numbers) {
        if (numbers.stream().distinct().count() != LOTTO_SIZE) {
            throw new IllegalArgumentException("lotto can't contain same numbers");
        }
    }

    private static void verifySize(final List<Integer> numbers) {
        if (numbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException("lotto size must be " + LOTTO_SIZE);
        }
    }

    public Long countMatches(final Lotto other) {
        return this.numbers.stream()
            .filter(other.numbers::contains)
            .count();
    }

    public boolean contains(final LottoNumber other) {
        return this.numbers.contains(other);
    }

    public List<LottoNumber> getLottoNumbers() {
        return this.numbers;
    }
}
