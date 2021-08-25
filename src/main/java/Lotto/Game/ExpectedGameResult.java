package Lotto.Game;

import Lotto.Number.WinningNumbers;
import Lotto.Ticket.LottoTicket;
import Lotto.Ticket.LottoTickets;
import Lotto.Ticket.Prize;

import java.util.List;

public class ExpectedGameResult {
    public static final int DECIMAL_POINTS_MAKER = 100;
    private final int firstPlaceCount;
    private final int secondPlaceCount;
    private final int thirdPlaceCount;
    private final int fourthPlaceCount;
    private final int loserCount;

    private final LottoTickets ticketsPuchasedThisWeek;
    private final WinningNumbers winningNumbersOfLastWeek;

    public ExpectedGameResult(List<LottoTicket> lottoTickets, WinningNumbers winningNumbers) {
        this.ticketsPuchasedThisWeek = new LottoTickets(lottoTickets);
        this.winningNumbersOfLastWeek = new WinningNumbers(winningNumbers.getValue());

        this.firstPlaceCount = getTicketCountForEachPrize(Prize.FIRST);
        this.secondPlaceCount = getTicketCountForEachPrize(Prize.SECOND);
        this.thirdPlaceCount = getTicketCountForEachPrize(Prize.THIRD);
        this.fourthPlaceCount = getTicketCountForEachPrize(Prize.FOURTH);
        this.loserCount = getTicketCountForEachPrize(Prize.LOSER);
    }

    private int getTicketCountForEachPrize(Prize prize) {
        return (int) ticketsPuchasedThisWeek.getValue().stream()
                .filter(ticket -> ticket.getPrize(winningNumbersOfLastWeek).equals(prize)).count();
    }

    public int countTicketsWinningPrize(Prize prize) {
        if (Prize.FIRST.equals(prize)) {
            return firstPlaceCount;
        }

        if (Prize.SECOND.equals(prize)) {
            return secondPlaceCount;
        }

        if (Prize.THIRD.equals(prize)) {
            return thirdPlaceCount;
        }


        if (Prize.FOURTH.equals(prize)) {
            return fourthPlaceCount;
        }


        if (Prize.LOSER.equals(prize)) {
            return loserCount;
        }

        throw new IllegalArgumentException("존재 하지 않는 상금 타입입니다."); // TODO: enum 이라 필요 없을것 같은데 필요할까?
    }

    public int getPrizeMoney() {
        return firstPlaceCount * Prize.FIRST.getValue() + secondPlaceCount * Prize.SECOND.getValue()
                + thirdPlaceCount * Prize.THIRD.getValue() + fourthPlaceCount * Prize.FOURTH.getValue();
    }

    public double getProfitRate(Payments payments) {
        return getProfitRateWithDecimalPoints(payments);
    }

    private double getProfitRateWithDecimalPoints(Payments payments) {
        return Math.round(dividePrizeMoneyByPayments(payments) * DECIMAL_POINTS_MAKER) / (double) DECIMAL_POINTS_MAKER;
    }

    private double dividePrizeMoneyByPayments(Payments payments) {
        return this.getPrizeMoney() / (double) payments.getValue();
    }
}
