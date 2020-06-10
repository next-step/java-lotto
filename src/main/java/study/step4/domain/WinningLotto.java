package study.step4.domain;

import java.util.Set;

public class WinningLotto {
    private LottoTicket winningLottoTicket;
    private LottoNumber bonusBall;

    public WinningLotto(String winningLottoNumbers, int bonusBall) {
        this(new LottoTicket(winningLottoNumbers), LottoNumber.cacheNumber(bonusBall));
    }

    public WinningLotto(LottoTicket winningLottoTicket, LottoNumber bonusBall) {
        bonusBall.validateDuplicationBonusBall(winningLottoTicket.getLottoNumbers());
        this.winningLottoTicket = winningLottoTicket;
        this.bonusBall = bonusBall;
    }

    public boolean isMatchBonus(Set<LottoNumber> lottoNumbers) {
        return bonusBall.isMatch(lottoNumbers);
    }

    public long matchCount(LottoTicket matchedLottos) {
        return winningLottoTicket.matchNumbers(matchedLottos);
    }
}
