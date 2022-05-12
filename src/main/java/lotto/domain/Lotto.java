package lotto.domain;

import lotto.constant.Rank;
import lotto.generator.RandomNumberGenerator;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Lotto {

    private final LottoNumbers lottoNumbers;
    private Rank rank;

    private Lotto(LottoNumbers lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public static Lotto createAutoLotto() {
        List<LottoNumber> randomLottoNumbers = RandomNumberGenerator.generate()
                .stream()
                .map(LottoNumber::valueOf)
                .collect(Collectors.toList());
        return new Lotto(new LottoNumbers(randomLottoNumbers));
    }

    public static Lotto valueOf(LottoNumbers lottoNumbers) {
        return new Lotto(lottoNumbers);
    }

    public void confirm(LottoNumbers winningNumbers, LottoNumber bonusNumber) {
        rank = Rank.valueOf(lottoNumbers.matchCount(winningNumbers),
                lottoNumbers.isContain(bonusNumber));
    }

    public boolean isSameRank(Rank rank) {
        return this.rank == rank;
    }

    public Rank findMatchResult() {
        return rank;
    }

    public LottoNumbers lottoNumbers() {
        return lottoNumbers;
    }

    @Override
    public String toString() {
        return lottoNumbers.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lotto lotto = (Lotto) o;
        return Objects.equals(lottoNumbers, lotto.lottoNumbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoNumbers);
    }
}
