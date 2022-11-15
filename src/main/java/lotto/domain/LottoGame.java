package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class LottoGame {
    private static final int TICKET_PRICE = 1000;

    public static List<LottoTicket> buy(final int moneyToBuyTicket) {
        return buy(moneyToBuyTicket, new ArrayList<>());
    }

    public static List<LottoTicket> buy(final int moneyToBuyTicket, List<List<Integer>> numbersForManualTicket) {
        int numberOfManualTickets = numbersForManualTicket.size();
        int numberOfAutoTickets = numberOfTickets(moneyToBuyTicket) - numberOfManualTickets;

        return Stream.concat(buyManualTickets(numbersForManualTicket), buyAutoTickets(numberOfAutoTickets))
                .collect(Collectors.toList());
    }

    private static Stream<LottoTicket> buyManualTickets(List<List<Integer>> numbersForManualTicket) {
        return numbersForManualTicket.stream()
                .map(LottoTicket::createFromIntegerList);
    }

    private static Stream<LottoTicket> buyAutoTickets(int numberOfTickets) {
        return IntStream.range(0, numberOfTickets)
                .mapToObj(i -> LottoTicket.create());
    }

    private static int numberOfTickets(final int moneyToBuyTicket) {
        return moneyToBuyTicket / TICKET_PRICE;
    }

    public static int getTicketCost(final int numberOfTickets) {
        return numberOfTickets * TICKET_PRICE;
    }
}
