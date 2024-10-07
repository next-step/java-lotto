package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Lotto {
    private static final int LOTTO_TICKET_PRICE = 1000;
    private static final int LOTTO_BOUND = 45;
    private static final int LOTTO_NUMBER_COUNT = 6;
    private static Random random = new Random();

    private Lotto() {
        throw new UnsupportedOperationException("해당 클래스는 인스턴스를 생성할 수 없습니다.");
    }

    public static List<List<Integer>> issueTickets(final int totalPurchasePrice) {
        validatePurchasePrice(totalPurchasePrice);
        int totalTicketCount = getTotalTicketCount(totalPurchasePrice);
        List<List<Integer>> tickets = new ArrayList<>(totalTicketCount);
        for (int i = 0; i < totalTicketCount; i++) {
            tickets.add(issueTicket());
        }
        return tickets;
    }

    private static List<Integer> issueTicket() {
        List<Integer> ticket = new ArrayList<>(LOTTO_NUMBER_COUNT);
        for (int j = 0; j < LOTTO_NUMBER_COUNT; j++) {
            ticket.add(generateUniqueLottoNumber(ticket));
        }
        ticketsSort(ticket);
        return ticket;
    }

    private static void ticketsSort(final List<Integer> ticket) {
        Collections.sort(ticket);
    }

    private static int generateUniqueLottoNumber(final List<Integer> ticket) {
        int lottoNumber = generateLottoNumber();
        while (ticket.contains(lottoNumber)) {
            lottoNumber = generateLottoNumber();
        }
        return lottoNumber;
    }

    private static int generateLottoNumber() {
        return random.nextInt(LOTTO_BOUND) + 1;
    }

    private static int getTotalTicketCount(final int totalPurchasePrice) {
        return totalPurchasePrice / LOTTO_TICKET_PRICE;
    }

    private static void validatePurchasePrice(final int totalPurchasePrice) {
        if (totalPurchasePrice % LOTTO_TICKET_PRICE != 0) {
            throw new IllegalArgumentException("올바른 구매금액이 아닙니다. 로또 개수에 맞게 금액을 넣어주세요.(1장당 1000원)");
        }
    }
}
