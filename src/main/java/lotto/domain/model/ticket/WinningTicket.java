package lotto.domain.model.ticket;

import lotto.domain.model.result.MatchStats;
import lotto.exception.InvalidWinningTicketException;

public class WinningTicket {

    private final LottoTicket winningTicket;
    private final LottoNumber bonusNumber;

    private WinningTicket(LottoTicket winningTicket, LottoNumber bonusNumber) {
        if (winningTicket.contains(bonusNumber)) {
            throw new InvalidWinningTicketException();
        }
        this.winningTicket = winningTicket;
        this.bonusNumber = bonusNumber;
    }

    public static WinningTicket of(LottoTicket winningTicket, LottoNumber bonusNumber) {
        return new WinningTicket(winningTicket, bonusNumber);
    }

    public MatchStats match(LottoTicket lottoTicket) {
        boolean matchBonus = lottoTicket.contains(bonusNumber);
        int countOfMatch = this.winningTicket.countMatches(lottoTicket);
        return MatchStats.of(countOfMatch, matchBonus);
    }
}
