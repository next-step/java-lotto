package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class LottoAutoMachine implements LottoMachine {

    private static final int MAX_BOUND = 6;
    private static final List<Integer> numbers = new ArrayList<>();

    static {
        IntStream.range(1, 45).forEach(numbers::add);
    }

    @Override
    public List<Integer> createLottoNumber() {
        Collections.shuffle(numbers);

        List<Integer> lottoPickNumber = new ArrayList<>();
        IntStream.range(0, MAX_BOUND)
                .forEach(i -> lottoPickNumber.add(numbers.get(i)));

        Collections.sort(lottoPickNumber);
        return lottoPickNumber;
    }
}
