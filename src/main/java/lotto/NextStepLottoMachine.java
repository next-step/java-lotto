package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class NextStepLottoMachine implements LottoMachine {
    private static final String DELIMITER = ", ";

    private static final List<LottoNumber> CACHE = new ArrayList<>();

    static {
        IntStream.rangeClosed(LottoNumber.MIN_VALUE, LottoNumber.MAX_VALUE)
                .forEach(value -> CACHE.add(LottoNumber.valueOf(value)));
    }

    @Override
    public LottoTickets automatic(final long amount) {
        Money purchase = Money.valueOf(amount);
        int count = purchase.divide(LottoTicket.PRICE);
        return createTickets(count);
    }

    private LottoTickets createTickets(final int count) {
        return IntStream.range(0, count)
                .mapToObj(ignore -> createTicket())
                .collect(Collectors.collectingAndThen(Collectors.toList(), LottoTickets::of));
    }

    private LottoTicket createTicket() {
        Collections.shuffle(CACHE);
        List<LottoNumber> shuffledNumber = new ArrayList<>(CACHE.subList(0, LottoTicket.LOTTO_NUMBER_COUNT));
        Collections.sort(shuffledNumber);
        return LottoTicket.of(shuffledNumber);
    }

    @Override
    public LottoTicket manual(final String numbers) {
        return LottoTicket.of(numbers.split(DELIMITER));
    }
}
