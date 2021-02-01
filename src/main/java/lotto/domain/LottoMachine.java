package lotto.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoMachine {

    private final List<Integer> numbers;

    private final static int MIN_LOTTO = 1;
    private final static int MAX_LOTTO = 45;
    private final static int MIN_LOTTO_COUNT = 0;
    private final static int MAX_LOTTO_COUNT = 6;

    public LottoMachine() {
        numbers = IntStream.range(MIN_LOTTO, MAX_LOTTO + 1).boxed().collect(Collectors.toList());
    }

    public List<Integer> generateTicket() {
        Collections.shuffle(numbers);
        List<Integer> ticket = numbers.subList(MIN_LOTTO_COUNT, MAX_LOTTO_COUNT);
        Collections.sort(ticket);
        return ticket;
    }
}
