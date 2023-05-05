package lotto;

import java.util.*;
import java.util.stream.Collectors;

public class Lotto {

    private List<LottoNumber> lottoNumbers;

    public static Lotto buy(final List<Integer> numbers) {
        return new Lotto(generate(numbers));
    }

    private static List<LottoNumber> generate(final List<Integer> numbers) {
        return numbers.stream()
                .map(LottoNumber::new)
                .collect(Collectors.toList());
    }

    private Lotto(final List<LottoNumber> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public Rank win(final Lotto lotto) {
        return Rank.win(lotto.matchCount(lottoNumbers));
    }

    private int matchCount(final List<LottoNumber> lottoNumbers) {
        return (int) this.lottoNumbers.stream()
                .filter(lottoNumbers::contains)
                .count();
    }

    public boolean hasSize(final int size) {
        return lottoNumbers.size() == size;
    }

}
