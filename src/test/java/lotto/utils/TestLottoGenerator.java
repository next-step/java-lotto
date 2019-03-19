package lotto.utils;

import java.util.Arrays;
import java.util.List;

public class TestLottoGenerator implements LottoGenerator {

    public List<Integer> generate() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        return numbers;
    }
}
