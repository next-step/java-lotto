package lotto.domain;

import java.util.*;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoFactory {

    private static final List<LottoNumber> NUMBERS;

    static {
        NUMBERS = IntStream.range(LottoNumber.MIN_NUMBER, LottoNumber.MAX_NUMBER + 1)
                .mapToObj(LottoNumber::valueOf)
                .collect(Collectors.toList());
    }

    private LottoFactory() {}

    public static List<LottoNumbers> buyTickets(int ticketCount) {
        return IntStream.range(0, ticketCount)
                .mapToObj(n -> provideLottoNumbers())
                .collect(Collectors.toList());
    }

    private static LottoNumbers provideLottoNumbers() {
        Collections.shuffle(NUMBERS);
        return LottoNumbers.of(new TreeSet<>(NUMBERS.subList(0, LottoNumbers.SIZE)));
    }

    public static List<LottoNumbers> buyTickets(int ticketCount,
                                                Supplier<List<Integer>> numberSupplier) {
        List<LottoNumbers> numbers = new ArrayList<>();
        for (int i = 0; i < ticketCount; i++) {
            numbers.add(LottoNumbers.of(numberSupplier.get()));
        }
        return numbers;
    }
}
