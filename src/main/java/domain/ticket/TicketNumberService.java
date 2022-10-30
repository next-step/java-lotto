package domain.ticket;

import util.RandomNumberGenerator;
import lottery.LotteryTicket;
import lottery.WinnerLotteryTicket;

import java.util.ArrayList;
import java.util.List;

public class TicketNumberService {
    public List<LotteryTicket> generateLotteryTicketNumbers(long countOfLotteryTickets) {
        List<LotteryTicket> lotteryTickets = new ArrayList<>();
        for (long count = 1; count <= countOfLotteryTickets; count++) {
            lotteryTickets.add(new LotteryTicket(RandomNumberGenerator.generateNumbers()));
        }

        return lotteryTickets;
    }

    public int verifyNumbers(double countOfMatchedNumbers, List<Integer> lotteryTicketNumber, WinnerLotteryTicket winnerLotteryTicket) {
        if (countOfMatchedNumbers == countOfMatchedNumbers(lotteryTicketNumber, winnerLotteryTicket)) {
            return 1;
        }
        return 0;
    }

    public int countOfMatchedNumbers(List<Integer> ticketNumbers, WinnerLotteryTicket winnerLotteryTicket) {
        return (int) ticketNumbers.stream().filter(winnerLotteryTicket.getWinnerLotteryTicket().getTicketNumbers()::contains).count();
    }

    public boolean hasBonusTicketNumber(LotteryTicket lotteryTicket, int bonusTicketNumber) {
        return lotteryTicket.getTicketNumbers().stream().anyMatch(number -> number == bonusTicketNumber);
    }
}
