package lotto.domain;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoFactory {

    public static final int TICKET_PRICE = 1000;
    private static List<LottoNumber> numbers;

    static {
        numbers = IntStream.range(LottoNumber.MIN_NUMBER, LottoNumber.MAX_NUMBER + 1)
                .mapToObj(LottoNumber::of)
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
        return LottoNumbers.of(new HashSet<>(numbers.subList(0, LottoNumbers.SIZE)));
    }
}
