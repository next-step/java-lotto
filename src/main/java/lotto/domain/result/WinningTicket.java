package lotto.domain.result;

import lotto.domain.BonusNumber;
import lotto.domain.LottoNumber;
import lotto.domain.ticket.LottoTicket;

public class WinningTicket {
    private final LottoTicket lottoTicket;
    private final BonusNumber bonusNumber;

    public WinningTicket(LottoTicket lottoTicket, BonusNumber bonusNumber) {
        validate(lottoTicket, bonusNumber);
        this.lottoTicket = lottoTicket;
        this.bonusNumber = bonusNumber;
    }

    private void validate(LottoTicket lottoTicket, BonusNumber bonusNumber) {
        if (lottoTicket.contains(bonusNumber)) {
            throw new IllegalArgumentException("보너스번호와 당첨번호는 중복될 수 없습니다");
        }
    }

    public boolean contains(LottoNumber lottoNumber) {
        return lottoTicket.contains(lottoNumber);
    }

    public boolean matchBonus(LottoNumber lottoNumber) {
        return bonusNumber.isSameNumber(lottoNumber);
    }
}
