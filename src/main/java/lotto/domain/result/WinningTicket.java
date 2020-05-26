package lotto.domain.result;

import lotto.domain.ticket.LottoTicket;

public class WinningTicket {
    private final LottoTicket lottoTicket;
    private final BonusNumber bonusNumber;

    public WinningTicket(LottoTicket lottoTicket, BonusNumber bonusNumber) {
        if (lottoTicket.contains(bonusNumber.getNumber())) {
            throw new IllegalArgumentException("보너스번호와 당첨번호는 중복될 수 없습니다");
        }
        this.lottoTicket = lottoTicket;
        this.bonusNumber = bonusNumber;
    }

    public boolean contains(final int lottoNumber) {
        return lottoTicket.contains(lottoNumber);
    }

    public boolean matchBonus(final int lottoNumber) {
        return bonusNumber.isSameNumber(lottoNumber);
    }
}
