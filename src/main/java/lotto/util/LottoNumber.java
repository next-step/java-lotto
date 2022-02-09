package lotto.util;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class LottoNumber {

    private final int START_NUMBER = 1;
    private final int LAST_NUMBER = 45;
    private final List<Integer> numbers = new ArrayList<>();

    public LottoNumber() {
        IntStream.rangeClosed(START_NUMBER, LAST_NUMBER).forEach(numbers::add);
    }

    public List<Integer> getLottoNumbers() {
        return numbers;
    }
}
