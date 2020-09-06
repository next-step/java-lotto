package lotto.domain;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoFactory {

    public static final int TICKET_PRICE = 1000;
    private static List<Integer> numbers;

    static {
        numbers = IntStream.range(LottoNumbers.MIN_NUMBER, LottoNumbers.MAX_NUMBER + 1)
                .boxed()
                .collect(Collectors.toList());
    }

    private LottoFactory() {}

    public static LottoBundle buyTickets(int payment) {
        List<LottoNumbers> tickets = IntStream.range(0, payment / TICKET_PRICE)
                .mapToObj(n -> provideLottoNumbers())
                .collect(Collectors.toList());
        return new LottoBundle(tickets);
    }

    private static LottoNumbers provideLottoNumbers() {
        Collections.shuffle(numbers);
        return new LottoNumbers(new ArrayList<>(numbers.subList(0, LottoNumbers.SIZE)));
    }
}
