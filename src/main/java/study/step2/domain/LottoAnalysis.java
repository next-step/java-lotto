package study.step2.domain;

import java.util.List;

public class LottoAnalysis {
    private static final String STRING_PROFIT = "이익";
    private static final String STRING_LOSS = "손해";
    private static final int DEFAULT_LOTTO_YIELD = 1;

    private final double analysis;

    public LottoAnalysis(List<LottoTicket> lottoTickets, LottoWinningNumber winnerNumber) {
        this.analysis = startAnalysis(lottoTickets, winnerNumber);
    }

    private double startAnalysis(List<LottoTicket> lottoTickets, LottoWinningNumber winnerNumber) {
        double lottoPrize = lottoTickets.stream()
                            .mapToDouble(ticket -> ticket.rank(winnerNumber).prize)
                            .sum();
        double buyAmount = lottoTickets.size() * 1000;
        return lottoPrize / buyAmount;
    }

    public double analyze() {
        return analysis;
    }

    public String stringAnalysis() {
        if (analysis >= DEFAULT_LOTTO_YIELD) {
            return STRING_PROFIT;
        }

        return STRING_LOSS;
    }
}
