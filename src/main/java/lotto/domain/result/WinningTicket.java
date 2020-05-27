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

    public boolean contains(LottoNumber lottoNumber) {
        return lottoTicket.contains(lottoNumber);
    }

    public boolean matchBonus(LottoNumber lottoNumber) {
        return bonusNumber.equals(lottoNumber);
    }
}
