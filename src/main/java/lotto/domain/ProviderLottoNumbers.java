package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class ProviderLottoNumbers {

    public static final int MIN_LOTTO_NUMBER = 1;
    public static final int MAX_LOTTO_NUMBER= 45;

    private static final List<Integer> numbers = new ArrayList<>();
    private static final int CAPACITY = 6;

    static {
        IntStream.rangeClosed(MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER).forEach(numbers::add);
    }

    private ProviderLottoNumbers() {}

    public static List<Integer> findAllLottoNumbers() {
        return numbers;
    }

    public static Lotto getLottoNumbers(LottoMachine lottoMachine) {
        return lottoMachine.createLotto(CAPACITY);
    }
}
