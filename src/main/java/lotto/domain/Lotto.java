package lotto.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import lotto.domain.vo.LottoNumber;

public class Lotto {

    private static final int LOTTO_SIZE = 6;
    private static final List<Integer> lottoNumberCandidates = IntStream.rangeClosed(
            LottoNumber.LOTTO_START,
            LottoNumber.LOTTO_END
        )
        .boxed()
        .collect(Collectors.toList());

    private final List<LottoNumber> numbers;

    private Lotto(final List<LottoNumber> numbers) {
        this.numbers = Collections.unmodifiableList(numbers);
    }

    public static Lotto createRandomLotto() {
        Collections.shuffle(lottoNumberCandidates);
        List<LottoNumber> lottoNumbers = lottoNumberCandidates.subList(0, LOTTO_SIZE)
            .stream()
            .map(LottoNumber::of)
            .collect(Collectors.toList());
        return new Lotto(lottoNumbers);
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
