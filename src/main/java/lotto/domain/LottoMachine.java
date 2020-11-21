package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.IntStream;

public abstract class LottoMachine {

    protected static final int MAX_BOUND = 6;
    protected static final List<Integer> numbers = new ArrayList<>();
    private static final int MAX_LOTTO_NUMBER_RANGE = 45;

    static {
        IntStream.rangeClosed(1, MAX_LOTTO_NUMBER_RANGE).forEach(numbers::add);
    }

    abstract Set<Integer> createLottoNumber();
}
