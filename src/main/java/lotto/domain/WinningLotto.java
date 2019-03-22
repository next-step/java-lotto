package lotto.domain;

import lotto.vo.LottoMatchResult;

import java.util.List;

public class WinningLotto {
    private final LottoTicket lottoNumbers;
    private final LottoNumber bonusNumber;

    public WinningLotto(List<Integer> lottoNumbers, int bonusNumber) {
        if (lottoNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("WinningLotto number must be unique");
        }

        this.lottoNumbers = new LottoTicket(lottoNumbers);
        this.bonusNumber = LottoNumber.get(bonusNumber);
    }

    int getMatchCounts(LottoTicket ticket) {
        return this.lottoNumbers.getNumberOfDuplicatedNumbers(ticket);
    }

    boolean isBonusNumberMatch(LottoTicket ticket) {
        return ticket.containsLottoNumber(this.bonusNumber);
    }

    public LottoMatchResult getMacthResult(LottoTicket ticket) {
        int matchCounts = getMatchCounts(ticket);
        boolean bonusNumberSame = isBonusNumberMatch(ticket);

        return new LottoMatchResult(matchCounts, bonusNumberSame);
    }
}