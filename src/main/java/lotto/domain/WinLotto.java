package lotto.domain;

import java.util.List;

public class WinLotto {
    private final LottoNumbers lottoNumbers;
    private final LottoNo bonusNumber;

    public WinLotto(LottoNumbers lottoNumbers) {
        this(lottoNumbers, null);
    }

    public WinLotto(List<LottoNo> numbers, LottoNo bonusNumber) {
        this(new LottoNumbers(numbers), bonusNumber);
    }

    public WinLotto(LottoNumbers lottoNumbers, LottoNo bonusNumber) {
        this.lottoNumbers = lottoNumbers;
        this.bonusNumber = bonusNumber;
    }


    public LottoNumbers numbers() {
        return lottoNumbers;
    }

    public LottoNo bonusNumber() {
        return bonusNumber;
    }

    public Rank checkRank(Lotto lotto) {
        int matchCount = this.lottoNumbers.countContains(lotto);
        boolean matchBonus = lotto.hasNumber(this.bonusNumber);
        return Rank.of(matchCount, matchBonus);
    }
}
