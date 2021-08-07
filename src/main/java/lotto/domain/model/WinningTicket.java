package lotto.domain.model;

import lotto.exception.InvalidWinningTicketException;

public class WinningTicket {

    private final LottoTicket lottoTicket;
    private final LottoNumber bonusNumber;

    private WinningTicket(LottoTicket lottoTicket, LottoNumber bonusNumber) {
        if (lottoTicket.contains(bonusNumber)) {
            throw new InvalidWinningTicketException();
        }
        this.lottoTicket = lottoTicket;
        this.bonusNumber = bonusNumber;
    }

    public static WinningTicket of(LottoTicket lottoTicket, LottoNumber bonusNumber) {
        return new WinningTicket(lottoTicket, bonusNumber);
    }

    public LottoRank match(LottoTicket lottoTicket) {
        boolean matchBonus = lottoTicket.contains(bonusNumber);
        int countOfMatch = this.lottoTicket.countMatches(lottoTicket);
        return LottoRank.of(countOfMatch, matchBonus);
    }
}
