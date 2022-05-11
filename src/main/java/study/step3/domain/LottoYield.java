package study.step3.domain;

import java.util.List;

public class LottoYield {
    private static final String STRING_PROFIT = "이익";
    private static final String STRING_LOSS = "손해";
    private static final int LOTTO_AMOUNT = 1000;
    private static final int DEFAULT_LOTTO_YIELD = 1;

    public static double operationYield(LottoTickets lottoTickets, LottoWinners lottoWinners) {
        List<LottoTicket> tickets = lottoTickets.readOnlyLottoTicket();
        double lottoPrize = tickets.stream()
                .mapToDouble(ticket -> LottoRank.valueOf(ticket, lottoWinners).winningMoney)
                .sum();
        double buyAmount = lottoTickets.lottoQuantity() * LOTTO_AMOUNT;
        return lottoPrize/buyAmount;
    }

    public static String stringYield(double yield) {
        if (yield >= DEFAULT_LOTTO_YIELD) {
            return STRING_PROFIT;
        }
        return STRING_LOSS;
    }
}
