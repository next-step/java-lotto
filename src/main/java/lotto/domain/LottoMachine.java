package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoMachine {
    public static final int LOTTO_PRICE = 1000;
    private static final int NUMBERS_COUNT = 6;
    private static final List<Integer> BASE_NUMBERS = IntStream.rangeClosed(1, 45).boxed().collect(
        Collectors.toList());

    public static List<LottoTicket> purchaseLottoTickets(int ticketAmount) {
        return generateLottoTickets(getTicketsCount(ticketAmount));
    }

    private static List<LottoTicket> generateLottoTickets(int ticketsCount) {
        checkMinimumTicketPurchaseRequirement(ticketsCount);
        List<LottoTicket> tickets = new ArrayList<>();
        for (int i = 0; i < ticketsCount; i++) {
            tickets.add(new LottoTicket(generateLottoNumbers()));
        }
        return tickets;
    }

    private static int getTicketsCount(int purchaseAmount) {
        return purchaseAmount / LOTTO_PRICE;
    }

    private static void checkMinimumTicketPurchaseRequirement(int ticketsCount) {
        if(ticketsCount<1){
            throw new IllegalArgumentException(String.format("%s원 단위로 한개 이상 구입해야합니다.", LOTTO_PRICE));
        }
    }

    private static List<Integer> generateLottoNumbers() {
        List<Integer> shuffledNumbers = new ArrayList<>(BASE_NUMBERS);
        Collections.shuffle(shuffledNumbers);
        return shuffledNumbers.subList(0, NUMBERS_COUNT).stream().sorted().collect(Collectors.toList());
    }
}
