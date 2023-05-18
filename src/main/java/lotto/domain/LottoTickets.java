package lotto.domain;

import java.util.*;
import java.util.stream.Collectors;

public class LottoTickets {
    private final List<Ticket> tickets;

    private LottoTickets(List<Ticket> tickets) {
        this.tickets = tickets;
    }

    public static LottoTickets from(List<Ticket> tickets) {
        return new LottoTickets(tickets);
    }

    public int numberOfTickets() {
        return tickets.size();
    }

    public int totalPrice() {
        return tickets.size() * 1000;
    }

    public boolean checkValidTickets() {
        return tickets.stream().allMatch(Ticket::checkValidTickets);
    }

    public static LottoTickets buyTickets(long money) {
        return LottoGenerator.generateTickets(money);
    }

    public List<Ticket> getTickets() {
        return tickets;
    }

    public WinningStatus winningStatus(WinningNumber winningNumber) {
        List<PrizeType> prizeTypes = listOfPrize(winningNumber);
        return makeWinningStatus(prizeTypes);
    }

    public List<PrizeType> listOfPrize(WinningNumber winningNumber) {
        return tickets.stream()
                .map(ticket -> ticket.checkLotteryWinningStatus(winningNumber))
                .collect(Collectors.toList());
    }

    private WinningStatus makeWinningStatus(List<PrizeType> prizeTypes) {
        Map<PrizeType, Integer> winningStatus = new HashMap<>();
        Arrays.stream(PrizeType.values())
                .forEach(prizeType -> winningStatus.put(prizeType, countPrizeType(prizeTypes, prizeType)));
        return WinningStatus.from(winningStatus);
    }

    public int countPrizeType(List<PrizeType> prizeTypes, PrizeType prizeType) {
        return (int) prizeTypes.stream()
                .filter(t -> t == prizeType)
                .count();
    }

    public double returnRate(WinningNumber winningNumber) {
        double result = (double) sumOfPrize(winningNumber) / totalPrice();
        return Math.floor(result * 100) / 100;
    }

    private long sumOfPrize(WinningNumber winningNumber) {
        long sum = 0;
        List<PrizeType> types = listOfPrize(winningNumber);
        for (PrizeType type : types) {
            sum += type.prize();
        }
        return sum;
    }
}
