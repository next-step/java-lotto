package lotto.domain;

import lotto.vo.LottoMatchResult;

import java.util.List;

public class WinningLotto {
    private final Lotto lottoNumbers;
    private final LottoNumber bonusNumber;

    public WinningLotto(List<Integer> lottoNumbers, int bonusNumber) {
        if (lottoNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("WinningLotto number must be unique");
        }

        this.lottoNumbers = new Lotto(lottoNumbers);
        this.bonusNumber = LottoNumber.getInstance(bonusNumber);
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
}