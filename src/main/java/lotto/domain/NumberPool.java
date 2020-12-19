package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class NumberPool {
    private static final int FROM_INDEX = 0;
    private static final int TO_INDEX = 6;
    public static final int MINIMUM_VALUE = 1;
    public static final int MAXIMUM_VALUE = 45;
    private final List<LottoNumber> numbers = new ArrayList<>();

    public NumberPool() {
        for (int i = MINIMUM_VALUE; i <= MAXIMUM_VALUE; i++) {
            numbers.add(new LottoNumber(i));
        }
    }

    public List<LottoNumber> getLottoNumbers() {
        Collections.shuffle(numbers);
        return new ArrayList<>(numbers.subList(FROM_INDEX, TO_INDEX));
    }
}
