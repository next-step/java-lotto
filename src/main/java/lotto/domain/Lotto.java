package lotto.domain;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Lotto {
    public static final int PRICE = 1_000;

    private final LottoNumbers lottoNumbers;

    public Lotto() {
        lottoNumbers = new LottoNumbers();
    }

    public Lotto(LottoNumbers lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public LottoRank findLottoRank(Lotto winningNumbers, LottoNumber bonusLottoNumber) {
        return LottoRank.findByMatchedCountAndBonus(countMatchedNumbers(winningNumbers), bonus(bonusLottoNumber));
    }

    public List<Integer> getNumbers() {
        return this.lottoNumbers.getNumbers()
                .stream()
                .map(LottoNumber::getNumber)
                .collect(Collectors.toList());
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

    private int countMatchedNumbers(Lotto winningLotto) {
        return this.lottoNumbers.matchedCount(winningLotto.lottoNumbers);
    }

    private boolean bonus(LottoNumber bonusLottoNumber) {
        return this.lottoNumbers.matchBonus(bonusLottoNumber);
    }
}
