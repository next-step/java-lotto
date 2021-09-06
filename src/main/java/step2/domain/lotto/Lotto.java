package step2.domain.lotto;

import step2.vo.Rank;

import java.util.List;

public class Lotto {

    protected final LottoNumbers lottoNumbers;

    public Lotto() {
        this.lottoNumbers = new LottoNumbers();
    }

    public Lotto(List<Integer> lottoNumbers) {
        this.lottoNumbers = new LottoNumbers(lottoNumbers);
    }

    public Lotto(LottoNumbers lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    @Override
    public String toString() {
        return lottoNumbers.toString();
    }

    protected Rank match(LottoNumbers winningLottoNumbers, LottoNumber bonusNumber) {
        final int matchCount = winningLottoNumbers.matchCount(this.lottoNumbers);
        final boolean bonusContained = this.lottoNumbers.contained(bonusNumber);
        return Rank.rank(matchCount, bonusContained);
    }
}
