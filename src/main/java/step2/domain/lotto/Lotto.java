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

    protected Lotto(LottoNumbers lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    @Override
    public String toString() {
        return lottoNumbers.toString();
    }

    protected Rank match(LottoNumbers winningLottoNumbers, LottoNumber bonusNumber) {
        final Rank rank = winningLottoNumbers.countNumberOfMatch(this.lottoNumbers);
        if (rank.equals(Rank.THIRD) && this.lottoNumbers.isContains(bonusNumber)) {
            return Rank.SECOND;
        }
        return rank;
    }
}
