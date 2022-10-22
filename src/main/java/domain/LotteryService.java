package domain;

import constant.Prize;
import constant.Rank;
import util.Calculator;
import util.RandomNumberGenerator;
import vo.LotteryTicket;
import vo.LotteryTickets;

import java.util.ArrayList;
import java.util.List;

public class LotteryService {

    private final int DEFAULT_LOTTERY_TICKET_PRICE = 1000;

    public long countOfLotteryTickets(long amount) {
        return (long) Calculator.divide(amount, DEFAULT_LOTTERY_TICKET_PRICE);
    }

    public long countOfLotteryWinners(int countOfMatchedNumbers, List<LotteryTicket> lotteryTickets, List<Integer> winnerTicket) {
        long result = 0L;
        for (LotteryTicket lotteryTicket : lotteryTickets) {
            result += verifyNumbers(countOfMatchedNumbers, lotteryTicket.getTicketNumbers(), winnerTicket);
        }

        return result;
    }

    private int verifyNumbers(int countOfMatchedNumbers, List<Integer> lotteryTicketNumber, List<Integer> winnerTicketNumber) {
        if (countOfMatchedNumbers == countOfMatchedNumbers(lotteryTicketNumber, winnerTicketNumber)) return 1;
        return 0;
    }

    private int countOfMatchedNumbers(List<Integer> ticketNumbers, List<Integer> winnerNumbers) {
        return (int) ticketNumbers.stream().filter(winnerNumbers::contains).count();
    }

    public List<LotteryTicket> generateLotteryTicketNumbers(long countOfLotteryTickets) {
        List<LotteryTicket> lotteryTickets = new ArrayList<>();
        for (long count = 1; count <= countOfLotteryTickets; count++) {
            lotteryTickets.add(new LotteryTicket(RandomNumberGenerator.generateNumbers()));
        }

        return lotteryTickets;
    }

    public long findTotalProfit(LotteryTickets lotteryTickets, LotteryTicket winnerTicket) {
        long result = 0L;

        for (LotteryTicket lotteryTicket : lotteryTickets.getLotteryTickets()) {
            long countOfMatchedNumber = countOfMatchedNumbers(lotteryTicket.getTicketNumbers(), winnerTicket.getTicketNumbers());
            result = Calculator.add(result, Prize.valueOf(new Rank(countOfMatchedNumber).findRank()).getPrize());
        }

        return result;
    }
}
