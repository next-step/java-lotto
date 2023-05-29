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
        return new LottoTickets(manualTickets.merge(autoTickets), manualTickets.numberOfTickets(), autoTickets.numberOfTickets());
    }

    private List<Ticket> merge(LottoTickets tickets) {
        List<Ticket> mergedTickets = new ArrayList<>();
        mergedTickets.addAll(this.tickets);
        mergedTickets.addAll(tickets.getTickets());
        return mergedTickets;
    }

    public int numberOfTickets() {
        return tickets.size();
    }

    public int totalPrice() {
        return tickets.size() * LOTTO_PRICE;
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
        List<Prize> prizeTypesOfTickets = listOfPrize(winningNumber);
        return makeWinningStatus(prizeTypesOfTickets);
    }

    public List<Prize> listOfPrize(WinningNumber winningNumber) {
        return tickets.stream()
                .map(ticket -> ticket.checkLotteryWinningStatus(winningNumber))
                .collect(Collectors.toList());
    }

    private WinningStatus makeWinningStatus(List<Prize> prizeTypesOfTickets) {
        return WinningStatus.from(prizeTypesOfTickets);
    }

    public double returnRate(WinningNumber winningNumber) {
        double result = (double) sumOfPrize(winningNumber) / totalPrice();
        return Math.floor(result * 100) / 100;
    }

    private long sumOfPrize(WinningNumber winningNumber) {
        List<Prize> types = listOfPrize(winningNumber);
        return types.stream()
                .mapToLong(Prize::prize)
                .sum();
    }

    public int getNumberOfManualTickets() {
        return numberOfManualTickets;
    }

    public int getNumberOfAutoTickets() {
        return numberOfAutoTickets;
    }
}