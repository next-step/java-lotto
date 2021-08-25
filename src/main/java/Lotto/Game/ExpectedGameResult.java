package Lotto.Game;

import Lotto.Number.WinningNumbers;
import Lotto.Ticket.LottoTicket;
import Lotto.Ticket.LottoTickets;
import Lotto.Ticket.Prize;

import java.util.Arrays;
import java.util.List;

public class ExpectedGameResult {
    public static final int DECIMAL_POINTS_MAKER = 100;

    private final LottoTickets tickets;
    private final WinningNumbers winningNumbers;

    public ExpectedGameResult(List<LottoTicket> lottoTickets, WinningNumbers winningNumbers) {
        this.tickets = new LottoTickets(lottoTickets);
        this.winningNumbers = new WinningNumbers(winningNumbers.getValue());

    }

    private int getTicketCountsWinning(Prize prize) {
        return (int) tickets.getValue().stream()
                .filter(ticket -> ticket.getPrize(winningNumbers).equals(prize)).count();
    }

    public int countTicketsWinning(Prize prize) {
        return getTicketCountsWinning(prize);
    }

    public int getTotalPrizeMoney() {
        return Arrays.stream(Prize.values()).mapToInt(prize -> prize.getValue() * getTicketCountsWinning(prize)).sum();
    }

    public double getProfitRate(Payments payments) {
        return getProfitRateWithDecimalPoints(payments);
    }

    private double getProfitRateWithDecimalPoints(Payments payments) {
        return Math.round(dividePrizeMoneyByPayments(payments) * DECIMAL_POINTS_MAKER) / (double) DECIMAL_POINTS_MAKER;
    }

    private double dividePrizeMoneyByPayments(Payments payments) {
        return this.getTotalPrizeMoney() / (double) payments.getValue();
    }
}
