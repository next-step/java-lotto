package lotto.domain;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoAutoMachine implements LottoMachine {

    private static final int LOTTO_NUMBER_CAPACITY = 6;

    private static final List<Integer> numbers = new ArrayList<>();
    private static final int MAX_LOTTO_NUMBER_RANGE = 45;

    static {
        IntStream.rangeClosed(1, MAX_LOTTO_NUMBER_RANGE).forEach(numbers::add);
    }

    @Override
    public LottoNumbers createLottoNumber() {
        Collections.shuffle(numbers);

        return new LottoNumbers(numbers.stream()
                                .limit(LOTTO_NUMBER_CAPACITY)
                                .sorted()
                                .collect(Collectors.toCollection(TreeSet::new)));
    }
}
