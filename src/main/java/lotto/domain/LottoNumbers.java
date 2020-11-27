package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class LottoNumbers {

    private static final List<Integer> numbers = new ArrayList<>();
    private static final int MAX_LOTTO_NUMBER_RANGE = 45;
    private static final int CAPACITY = 6;

    static {
        IntStream.rangeClosed(1, MAX_LOTTO_NUMBER_RANGE).forEach(numbers::add);
    }

    private LottoNumbers() {}

    public static List<Integer> findAllLottoNumbers() {
        return numbers;
    }

    public static Lotto getLottoNumbers(LottoMachine lottoMachine) {
        return lottoMachine.createLotto(CAPACITY);
    }
}
