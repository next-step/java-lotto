package LottoTest;

import lotto.domain.LottoNumber;

import java.util.Arrays;
import java.util.List;

public class FixedLottoNumber implements LottoNumber {
    @Override
    public List<Integer> numbers() {
        return Arrays.asList(1, 2, 3, 4, 5, 6);
    }
}
