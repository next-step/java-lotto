package lotto.domain;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoFactory {

    public static final int TICKET_PRICE = 1000;
    private static final List<LottoNumber> NUMBERS;

    static {
        NUMBERS = IntStream.range(LottoNumber.MIN_NUMBER, LottoNumber.MAX_NUMBER + 1)
                .mapToObj(LottoNumber::valueOf)
                .collect(Collectors.toList());
    }

    private LottoFactory() {}

    public static List<LottoNumbers> buyTickets(int payment) {
        return IntStream.range(0, payment / TICKET_PRICE)
                .mapToObj(n -> provideLottoNumbers())
                .collect(Collectors.toList());
    }

    private static LottoNumbers provideLottoNumbers() {
        Collections.shuffle(NUMBERS);
        return LottoNumbers.of(new HashSet<>(NUMBERS.subList(0, LottoNumbers.SIZE)));
    }
}
