package lotto.domain.result;

import lotto.domain.LottoNumber;
import lotto.domain.ticket.LottoTicket;

public class WinningTicket {
    private final LottoTicket lottoTicket;
    private final LottoNumber bonusNumber;

    public WinningTicket(LottoTicket lottoTicket, LottoNumber bonusNumber) {
        validate(lottoTicket, bonusNumber);
        this.lottoTicket = lottoTicket;
        this.bonusNumber = bonusNumber;
    }

    private void validate(LottoTicket lottoTicket, LottoNumber bonusNumber) {
        if (lottoTicket.contains(bonusNumber)) {
            throw new IllegalArgumentException("보너스번호와 당첨번호는 중복될 수 없습니다");
        }
    }

    public LottoPrize checkLottoNumbers(final LottoTicket lottoTicket) {
        return LottoPrize.findByMathCount(this.lottoTicket.getMatchCount(lottoTicket), lottoTicket.contains(bonusNumber));
    }
}
