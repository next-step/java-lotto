package lotto.domain;

import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class Lotto {
    private static final int LOTTO_NUMBER_SIZE = 6;

    private final Set<LottoNumber> numbers;

    public static Lotto from(final String lottoString) {
        Set<LottoNumber> numbers = Arrays.stream(lottoString.split(","))
                .map(String::trim)
                .map(LottoNumber::new)
                .collect(Collectors.toSet());
        return new Lotto(numbers);
    }

    public Lotto(final Set<LottoNumber> numbers) {
        this.validateLotto(numbers.size());
        this.numbers = new TreeSet<>(numbers);
    }

    public String getNumbers() {
        return this.numbers.stream()
                .map(LottoNumber::getNumber)
                .collect(Collectors.joining(", "));
    }

    public Rank getRank(Lotto lotto) {
        return Rank.matchNumber(this.sameLottoNumberCount(lotto));
    }

    private long sameLottoNumberCount(Lotto lotto) {
        return this.numbers.stream()
                .filter(lotto.numbers::contains)
                .count();
    }

    private void validateLotto(final int count) {
        if (count == LOTTO_NUMBER_SIZE) {
            throw new IllegalArgumentException();
        }
    }
}
