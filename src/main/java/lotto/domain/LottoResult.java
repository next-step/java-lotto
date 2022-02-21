package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoResult {

    private final List<LottoTicket> lottoTickets;
    private final WinningNumbers winningNumbers;

    public LottoResult(final List<LottoTicket> lottoTickets, final WinningNumbers winningNumbers) {
        this.lottoTickets = lottoTickets;
        this.winningNumbers = winningNumbers;
    }

    public List<LottoRank> createLottoResult() {
        final List<LottoRank> rankResult = new ArrayList<>();
        lottoTickets.forEach(ticket -> {
            LottoRank lottoRank = winningNumbers.getRankForLottoTicket(ticket);
            if (lottoRank != null) {
                rankResult.add(winningNumbers.getRankForLottoTicket(ticket));
            }
        });
        return rankResult;
    }


}
