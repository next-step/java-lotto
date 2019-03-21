package lotto.domain.ticket;

import lotto.enums.LottoRank;
import lotto.vo.LottoMatchResult;

import java.util.List;

public class Lotto {
    private final LottoNumbers lottoNumbers;
    private final LottoNumber bonusNumber;

    public Lotto(List<Integer> lottoNumbers, int bonusNumber) {
        if (lottoNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("Lotto number must be unique");
        }

        this.lottoNumbers = new LottoNumbers(lottoNumbers);
        this.bonusNumber = new LottoNumber(bonusNumber);
    }

    int getMatchCounts(Lotto target) {
        int matchCounts = this.lottoNumbers.getNumberOfDuplicatedNumbers(target.lottoNumbers);

        if ((LottoRank.THIRD.getMatchCount() == matchCounts) && (isBonusNumberMatch(target))) {
            return LottoRank.SECOND.getMatchCount();
        }

        return matchCounts;
    }

    boolean isBonusNumberMatch(Lotto target) {
        return this.bonusNumber.isEqualTo(target.bonusNumber);
    }

    public LottoMatchResult getResult(Lotto winner) {
        int matchCounts = getMatchCounts(winner);
        boolean bonusNumberSame = isBonusNumberMatch(winner);

        return new LottoMatchResult(matchCounts, bonusNumberSame);
    }

    @Override
    public String toString() {
        return this.lottoNumbers.toString() + " / " + bonusNumber;
    }
}