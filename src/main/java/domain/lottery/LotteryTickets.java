package domain.lottery;

import util.Calculator;
import util.RandomNumberGenerator;

import java.util.ArrayList;
import java.util.List;

import static constant.LotteryRules.DEFAULT_LOTTERY_TICKET_PRICE;

public class LotteryTickets {
    private final List<LotteryTicket> lotteryTickets;

    public LotteryTickets(long amount) {
        int countOfLotteryTickets = (int) Calculator.divide(amount, DEFAULT_LOTTERY_TICKET_PRICE);
        lotteryTickets = new ArrayList<>(countOfLotteryTickets);
        for (long count = 1; count <= countOfLotteryTickets; count++) {
            lotteryTickets.add(LotteryTicket.of(RandomNumberGenerator.generateNumbers()));
        }
    }

    public LotteryTickets(int numberOfLotteryTickets) {
        lotteryTickets = new ArrayList<>(numberOfLotteryTickets);
        for (long count = 1; count <= numberOfLotteryTickets; count++) {
            lotteryTickets.add(LotteryTicket.of(RandomNumberGenerator.generateNumbers()));
        }
    }

    public LotteryTickets(List<LotteryTicket> lotteryTickets) {
        this.lotteryTickets = lotteryTickets;
    }

    public void add(LotteryTicket lotteryTicket) {
        lotteryTickets.add(lotteryTicket);
    }

    public List<LotteryTicket> getLotteryTickets() {
        return lotteryTickets;
    }
}
