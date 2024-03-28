package lottery.service;

import lottery.code.WinPrizeType;
import lottery.domain.LottoTickets;
import lottery.domain.WinningLotto;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Map;

public class LottoDrawer {

    private final LottoTickets lottoTickets;

    private final WinningLotto winningLotto;

    public LottoDrawer(LottoTickets lottoTickets,
                       WinningLotto winningLotto) {
        this.lottoTickets = lottoTickets;
        this.winningLotto = winningLotto;
    }

    public Map<WinPrizeType, Long> winStatistics() {
        return lottoTickets.winStatistics(winningLotto);
    }

    public BigDecimal profitRate() {
        BigDecimal spent = BigDecimal.valueOf(lottoTickets.lottoTicketsTotalPrice());
        BigDecimal profit = BigDecimal.valueOf(lottoTickets.lottoTicketsTotalPrize(winStatistics()));
        return profit.divide(spent, 2, RoundingMode.DOWN);
    }
}
