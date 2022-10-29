package domain;

import constant.Prize;
import constant.Rank;
import util.Calculator;
import vo.LotteryTicket;
import vo.LotteryTickets;

import java.util.List;

public class LotteryWinningService {

    public long countOfLotteryWinners(int countOfMatchedNumbers, List<LotteryTicket> lotteryTickets, List<Integer> winnerTicket, TicketNumberService ticketNumberService) {
        long result = 0L;
        for (LotteryTicket lotteryTicket : lotteryTickets) {
            result += ticketNumberService.verifyNumbers(countOfMatchedNumbers, lotteryTicket.getTicketNumbers(), winnerTicket);
        }

        return result;
    }

    public long findTotalProfit(LotteryTickets lotteryTickets, LotteryTicket winnerTicket, TicketNumberService ticketNumberService) {
        long result = 0L;

        for (LotteryTicket lotteryTicket : lotteryTickets.getLotteryTickets()) {
            long countOfMatchedNumber = ticketNumberService.countOfMatchedNumbers(lotteryTicket.getTicketNumbers(), winnerTicket.getTicketNumbers());
            result = Calculator.add(result, Prize.valueOf(new Rank(countOfMatchedNumber).findRank()).getPrize());
        }

        return result;
    }
}
