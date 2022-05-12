package study.step3.domain;

import java.util.List;

public class LottoYield {
    private static final int LOTTO_AMOUNT = 1000;

    private LottoYield() {}

    public static double operationYield(LottoTickets lottoTickets, LottoWinners lottoWinners) {
        List<LottoTicket> tickets = lottoTickets.readOnlyLottoTicket();
        double lottoPrize = tickets.stream()
                .mapToDouble(ticket -> LottoRank.valueOf(ticket, lottoWinners).winningMoney)
                .sum();
        double buyAmount = lottoTickets.lottoQuantity() * LOTTO_AMOUNT;
        return lottoPrize/buyAmount;
    }
}
