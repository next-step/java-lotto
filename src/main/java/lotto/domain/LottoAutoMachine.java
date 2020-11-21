package lotto.domain;

import java.util.*;
import java.util.stream.IntStream;

public class LottoAutoMachine extends LottoMachine {

    @Override
    public Set<Integer> createLottoNumber(int capacity) {
        Collections.shuffle(numbers);

        Set<Integer> lottoPickNumber = new LinkedHashSet<>();
        IntStream.range(0, capacity)
                .forEach(i -> lottoPickNumber.add(numbers.get(i)));

        return lottoPickNumber;
    }
}
