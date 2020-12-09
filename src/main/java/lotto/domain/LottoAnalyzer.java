package lotto.domain;

public class LottoAnalyzer {
    public static LottoReport analyze(final LottoTickets lottoTickets, final LottoTicket winning) {
        return LottoReport.of(lottoTickets.match(winning));
    }
}
