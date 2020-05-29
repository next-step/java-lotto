package lotto.domain.lotto;

import lotto.domain.winning.WinningNumbers;
import lotto.domain.winning.WinningStatistics;

import java.util.Map;

public class LottoGame {

    private final Price price;
    private final LottoTicket lottoTicket;

    public LottoGame(Price price, LottoTicket lottoTicket) {
        this.price = price;
        this.lottoTicket = lottoTicket;
    }

    public WinningStatistics execute(WinningNumbers winningNumbers) {
        Map<LottoRank, Long> lottoRank = this.lottoTicket.matchWinningNumber(winningNumbers);
        return new WinningStatistics(this.price, lottoRank);
    }
}
