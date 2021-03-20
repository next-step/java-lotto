package lotto.domain;

import java.util.List;

public class LottoYield {
    private static final String STRING_PROFIT = "이익";
    private static final String STRING_LOSS = "손해";
    private static final int LOTTO_AMOUNT = 1000;
    private static final int DEFAULT_LOTTO_YIELD = 1;

    private final double yield;

    public LottoYield(double yield) {
        this.yield = yield;
    }

    public LottoYield(List<LottoTicket> lottoTickets,
            LottoNumbers winnerNumber, LottoNumbers bonusNumber) {
        this.yield = operationYield(lottoTickets, winnerNumber, bonusNumber);
    }

    private double operationYield(List<LottoTicket> lottoTickets,
            LottoNumbers winnerNumber, LottoNumbers bonusNumber) {
        double lottoPrize = lottoTickets.stream()
                            .mapToDouble(ticket -> LottoRank.valueOf(ticket, winnerNumber, bonusNumber).winningMoney)
                            .sum();

        double buyAmount = lottoTickets.size() * LOTTO_AMOUNT;

        return lottoPrize / buyAmount;
    }

    public double yield() {
        return yield;
    }

    public String stringYield() {
        if (yield >= DEFAULT_LOTTO_YIELD) {
            return STRING_PROFIT;
        }

        return STRING_LOSS;
    }

    public boolean checkYield(double yield) {
        return this.yield == yield;
    }
}
