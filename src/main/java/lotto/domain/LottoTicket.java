package lotto.domain;

import lotto.rule.LottoSetUp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoTicket {
    private final int LOTTO_NUMBER_COUNT;
    private final int LOTTO_NUMBER_BOUND;

    private List<Integer> ticket;

    public LottoTicket() {
        LOTTO_NUMBER_COUNT = LottoSetUp.lottoNumberCount;
        LOTTO_NUMBER_BOUND = LottoSetUp.lottoNumberBounds;
        ticket = new ArrayList<Integer>();

        List<Integer> numbers = new ArrayList<Integer>();
        for (int bound = 1; bound <= LOTTO_NUMBER_BOUND; bound++) {
            numbers.add(bound);
        }
        Collections.shuffle(numbers);
        for (int index = 0; index < LOTTO_NUMBER_COUNT; index++) {
            ticket.add(numbers.get(index));
        }

        Collections.sort(ticket);
    }

    public List<Integer> getTicket() {
        return this.ticket;
    }

    @Override
    public String toString() {
        List<String> newTicket = new ArrayList<String>();
        for (Integer number : ticket) {
            newTicket.add(String.valueOf(number));
        }

        String tickets = String.join(", ", newTicket);
        return "[" + tickets + "]";
    }
}
