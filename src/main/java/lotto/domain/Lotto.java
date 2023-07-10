package lotto.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lotto {

    private static final int LOTTO_SIZE = 6;
    private static final List<LottoNumber> values = IntStream.rangeClosed(
            LottoNumber.LOTTO_START,
            LottoNumber.LOTTO_END
        )
        .boxed()
        .map(LottoNumber::new)
        .collect(Collectors.toList());

    private final List<LottoNumber> numbers;

    private Lotto(final List<LottoNumber> numbers) {
        this.numbers = Collections.unmodifiableList(numbers);
    }

    public static Lotto createRandomLotto() {
        Collections.shuffle(values);
        return new Lotto(values.subList(0, LOTTO_SIZE));
    }

    public static Lotto createSpecificLotto(final List<Integer> numbers) {

        verifySize(numbers);
        verifyDuplicate(numbers);

        return new Lotto(
            numbers.stream()
                .map(LottoNumber::new)
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

    public List<LottoNumber> getLottoNumbers() {
        return this.numbers;
    }
}
