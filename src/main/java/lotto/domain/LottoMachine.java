package lotto.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoMachine {

    private final List<Integer> numbers;
    private final static int MIN_LOTTO = 1;
    private final static int MAX_LOTTO = 46;
    private final static int FIRST_LOTTO_INDEX = 0;
    private final static int END_LOTTO_INDEX = 6;

    public LottoMachine() {
        numbers = IntStream.range(MIN_LOTTO, MAX_LOTTO).boxed().collect(Collectors.toList());
    }

    public List<Integer> generateTicket() {
        Collections.shuffle(numbers);
        List<Integer> ticket = numbers.subList(FIRST_LOTTO_INDEX, END_LOTTO_INDEX);
        Collections.sort(ticket);
        return ticket;
    }

}
