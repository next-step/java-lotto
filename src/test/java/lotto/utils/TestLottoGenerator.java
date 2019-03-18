package lotto.utils;

import java.util.ArrayList;
import java.util.List;

public class TestLottoGenerator implements LottoGenerator {

    public List<Integer> generate() {
        List<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);
        numbers.add(5);
        numbers.add(6);

        return numbers;
    }
}
