package lotto.domain;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoAutoMachine implements LottoMachine {

    protected static final List<Integer> numbers = new ArrayList<>();
    private static final int MAX_LOTTO_NUMBER_RANGE = 45;

    static {
        IntStream.rangeClosed(1, MAX_LOTTO_NUMBER_RANGE).forEach(numbers::add);
    }

    @Override
    public Set<Integer> createLottoNumber(int capacity) {
        Collections.shuffle(numbers);

        Set<Integer> lottoPickNumber = new TreeSet<>();
        IntStream.range(0, capacity)
                .forEach(i -> lottoPickNumber.add(numbers.get(i)));

        return lottoPickNumber;
    }
}
