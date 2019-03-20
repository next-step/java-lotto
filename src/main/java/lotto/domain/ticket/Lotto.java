package lotto.domain.ticket;

import lotto.enums.LottoRank;
import java.util.List;

public class Lotto {
    private final LottoNumbers lottoNumbers;
    private final LottoNumber bonusNumber;

    public Lotto(List<Integer> lottoNumbers, int bonusNumber) {
        this.lottoNumbers = new LottoNumbers(lottoNumbers);
        this.bonusNumber = new LottoNumber(bonusNumber);
    }

    public int getMatchCounts(Lotto target) {
        int matchCounts = this.lottoNumbers.getNumberOfDuplicatedNumbers(target.lottoNumbers);

        if ((LottoRank.THIRD.getMatchCount() == matchCounts) && (isBonusNumberSame(target))) {
            return LottoRank.SECOND.getMatchCount();
        }

        return matchCounts;
    }

    public boolean isBonusNumberSame(Lotto target) {
        return this.bonusNumber.equalsTo(target.bonusNumber);
    }
}