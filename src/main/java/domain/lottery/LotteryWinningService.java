package domain.lottery;

import constant.Prize;
import constant.Rank;
import domain.ticket.TicketNumberService;
import dto.Result;
import dto.lottery.LotteryTicket;
import dto.lottery.LotteryTickets;
import dto.lottery.WinnerLotteryTicket;

import java.util.List;

public class LotteryWinningService {
    public long countOfLotteryWinners(double countOfMatchedNumbers, List<LotteryTicket> lotteryTickets, WinnerLotteryTicket winnerTicket, TicketNumberService ticketNumberService) {
        Result result = new Result(0);
        for (LotteryTicket lotteryTicket : lotteryTickets) {
            result.add(ticketNumberService.verifyNumbers(countOfMatchedNumbers, lotteryTicket.getTicketNumbers(), winnerTicket));
        }

        return result.getResult();
    }

    public long findTotalRewards(LotteryTickets lotteryTickets, WinnerLotteryTicket winnerTicket, TicketNumberService ticketNumberService) {
        Result result = new Result(0);

        for (LotteryTicket lotteryTicket : lotteryTickets.getLotteryTickets()) {
            int countOfMatchedNumber = ticketNumberService.countOfMatchedNumbers(lotteryTicket.getTicketNumbers(), winnerTicket);
            result.add(Prize.valueOf(new Rank(countOfMatchedNumber, ticketNumberService.hasBonusTicketNumber(lotteryTicket, winnerTicket.getBonusTicketNumber())).findRank()).getPrize());
        }

        return result.getResult();
    }
}
