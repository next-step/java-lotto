package domain;

import util.RandomNumberGenerator;
import vo.LotteryTicket;

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

    public int verifyNumbers(int countOfMatchedNumbers, List<Integer> lotteryTicketNumber, List<Integer> winnerTicketNumber) {
        if (countOfMatchedNumbers == countOfMatchedNumbers(lotteryTicketNumber, winnerTicketNumber)) return 1;
        return 0;
    }

    public int countOfMatchedNumbers(List<Integer> ticketNumbers, List<Integer> winnerNumbers) {
        return (int) ticketNumbers.stream().filter(winnerNumbers::contains).count();
    }
}
