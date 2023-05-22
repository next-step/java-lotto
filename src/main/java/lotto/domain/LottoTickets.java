package lotto.domain;

import lotto.exception.TicketNumberOutOfBoundException;
import lotto.exception.TicketPriceOutOfBoundException;

import java.util.*;
import java.util.stream.Collectors;

import static lotto.domain.Ticket.LOTTO_PRICE;

public class LottoTickets {
    private final List<Ticket> tickets;
    private final Integer numberOfManualTickets;
    private final Integer numberOfAutoTickets;

    private LottoTickets(List<Ticket> tickets, int numberOfManualTickets, int numberOfAutoTickets) {
        this.tickets = tickets;
        this.numberOfManualTickets = numberOfManualTickets;
        this.numberOfAutoTickets = numberOfAutoTickets;
    }

    public static LottoTickets from(List<Ticket> tickets) {
        return new LottoTickets(tickets, 0, 0);
    }

    public static LottoTickets of(LottoTickets manualTickets, LottoTickets autoTickets) {
        List<Ticket> tickets = new ArrayList<>();
        tickets.addAll(manualTickets.getTickets());
        tickets.addAll(autoTickets.getTickets());
        return new LottoTickets(tickets, manualTickets.numberOfTickets(), autoTickets.numberOfTickets());
    }

    public int numberOfTickets() {
        return tickets.size();
    }

    public int totalPrice() {
        return tickets.size() * 1000;
    }

    public static LottoTickets buyTickets(long money, List<Ticket> manualTickets) throws TicketNumberOutOfBoundException, TicketPriceOutOfBoundException {
        if (money < 0) {
            throw new TicketPriceOutOfBoundException("가격은 음수가 불가능합니다.");
        }
        int numberOfManualTicket = manualTickets.size();
        int numberOfAutoTicket = (int) (money / LOTTO_PRICE) - numberOfManualTicket;
        return LottoTickets.of(buyManualTickets(manualTickets), buyAutoTickets(numberOfAutoTicket));
    }

    public static LottoTickets buyManualTickets(List<Ticket> tickets) {
        return LottoGenerator.generateManualTickets(tickets);
    }

    public static LottoTickets buyAutoTickets(long numberOfTicket) throws TicketNumberOutOfBoundException {
        if (numberOfTicket < 0) {
            throw new TicketNumberOutOfBoundException("티켓 개수는 음수가 불가능합니다.");
        }
        return LottoGenerator.generateAutoTickets(numberOfTicket);
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

    public int getNumberOfManualTickets() {
        return numberOfManualTickets;
    }

    public int getNumberOfAutoTickets() {
        return numberOfAutoTickets;
    }
}