package lotto.domain.ticket;

import lotto.domain.LottoRank;
import lotto.domain.winning.WinningNumbers;
import lotto.domain.winning.WinningTickets;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LottoTickets {
    private final List<LottoTicket> lottoTickets;

    public LottoTickets(List<LottoTicket> lottoTickets) {
        this.lottoTickets = new ArrayList<>(lottoTickets);
    }

    public WinningTickets findWinning(WinningNumbers winningNumbers) {
        return new WinningTickets(
            lottoTickets.stream()
                        .collect(Collectors.groupingBy(
                            lottoTicket -> LottoRank.valueOf(lottoTicket.findMatchCount(winningNumbers),
                                                             lottoTicket.getMatchedBonus())
                        )));
    }

    public String getLottoTicketString(int index) {
        return lottoTickets.get(index).toString();
    }

    public int getLottoTicketsSize() {
        return lottoTickets.size();
    }

}
