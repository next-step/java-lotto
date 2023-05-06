package lotto.domain;

import java.util.*;
import java.util.stream.Collectors;

public class Lotto {

    private final List<LottoNumber> lottoNumbers;

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

    public Rank win(final Lotto lotto, final LottoNumber lottoNumber) {
        return Rank.win(lotto.matchCount(lottoNumbers), lotto.matchBonusNumber(lottoNumber));
    }

    private int matchCount(final List<LottoNumber> lottoNumbers) {
        return (int) this.lottoNumbers.stream()
                .filter(lottoNumbers::contains)
                .count();
    }

    private boolean matchBonusNumber(final LottoNumber bonusNumber) {
        return this.lottoNumbers
                .stream()
                .sorted(Comparator.reverseOrder())
                .findFirst()
                .map(lottoNumber -> lottoNumber.isMatch(bonusNumber))
                .orElse(false);
    }

    public boolean hasSize(final int size) {
        return lottoNumbers.size() == size;
    }

    public List<Integer> getNumbers() {
        return lottoNumbers.stream().map(LottoNumber::getNumber).collect(Collectors.toList());
    }

}
