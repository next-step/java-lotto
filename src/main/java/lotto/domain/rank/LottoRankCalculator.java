package lotto.domain.rank;

import lotto.domain.lotto.LottoNumber;
import lotto.domain.lotto.LottoTicket;

public class LottoRankCalculator {

    private LottoTicket winLottoTicket;
    private LottoNumber bonusNumber;

    public LottoRankCalculator(LottoTicket winLottoTicket, LottoNumber bonusNumber) {
        validateBonusNumber(winLottoTicket, bonusNumber);
        this.winLottoTicket = winLottoTicket;
        this.bonusNumber = bonusNumber;
    }

    public LottoRank calculate(LottoTicket lottoTicket) {
        int matchCount = winLottoTicket.matchLottoTicketCount(lottoTicket);
        Boolean isMatchBonusNumber = lottoTicket.hasBonusNumber(bonusNumber);
        return LottoRank.valueOf(matchCount, isMatchBonusNumber);
    }

    private void validateBonusNumber(LottoTicket winLottoTicket, LottoNumber lottoBonusNumber) {
        if (winLottoTicket.hasBonusNumber(lottoBonusNumber)) {
            throw new IllegalArgumentException("보너스 번호는 당첨번호와 중복될 수 없습니다.");
        }
    }

}
