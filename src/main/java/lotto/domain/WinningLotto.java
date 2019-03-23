package lotto.domain;

import lotto.vo.LottoMatchResult;

import java.util.List;

public class WinningLotto {
    private final Lotto lottoNumbers;
    private final LottoNumber bonusNumber;

    public WinningLotto(List<LottoNumber> lottoNumbers, LottoNumber bonusNumber) {
        if (lottoNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("WinningLotto number must be unique");
        }

        this.lottoNumbers = new Lotto(lottoNumbers);
        this.bonusNumber = bonusNumber;
    }

    int getMatchCounts(Lotto ticket) {
        return this.lottoNumbers.getNumberOfDuplicatedNumbers(ticket);
    }

    boolean isBonusNumberMatch(Lotto ticket) {
        return ticket.containsLottoNumber(this.bonusNumber);
    }

    public LottoMatchResult getMatchResult(Lotto ticket) {
        int matchCounts = getMatchCounts(ticket);
        boolean bonusNumberSame = isBonusNumberMatch(ticket);

        return new LottoMatchResult(matchCounts, bonusNumberSame);
    }

    public boolean isEqualTo(WinningLotto target) {
        int matchCounts= getMatchCounts(target.lottoNumbers);

        return (matchCounts == Lotto.LOTTO_NUMBERS_SIZE) &&
                (this.bonusNumber == target.bonusNumber);
    }
}