package LottoTest;

import lotto.domain.LottoNumber;

import java.util.Arrays;
import java.util.List;

public class FixedLottoNumber implements LottoNumber {
    private static final int MIN = 1;
    private static final int MAX = 45;

    @Override
    public List<Integer> numbers() {
        return Arrays.asList(1, 2, 3, 4, 5, 6);
    }

    @Override
    public int min() {
        return MIN;
    }

    @Override
    public int max() {
        return MAX;
    }
}
