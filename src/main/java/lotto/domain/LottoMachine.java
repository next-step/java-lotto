package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public abstract class LottoMachine {

    protected static final int MAX_BOUND = 6;
    protected static final List<Integer> numbers = new ArrayList<>();

    static {
        IntStream.range(1, 46).forEach(numbers::add);
    }

    abstract List<Integer> createLottoNumber();
}
