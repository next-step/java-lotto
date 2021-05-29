package lotto.domain;

import java.util.*;

public class AutoLottoTicketGenerator {

    private final int NUMBER_COUNT_PER_TICKET = 6;

    private static final List<Integer> numberPool = new ArrayList<>();

    static {
        for (int i = LottoNumber.MIN_VALUE; i <= LottoNumber.MAX_VALUE; i++) {
            numberPool.add(i);
        }
    }

    public List<LottoTicket> generate(int count) {
        List<LottoTicket> tickets = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            Collections.shuffle(numberPool);
            tickets.add(extract());
        }
        return tickets;
    }

    private LottoTicket extract() {
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < NUMBER_COUNT_PER_TICKET; i++) {
            numbers.add(numberPool.get(i));
        }
        Collections.sort(numbers);

        return new LottoTicket(numbers);
    }
}
