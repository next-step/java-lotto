package lotto.domain.machine;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;
import lotto.domain.lotto.LottoNumber;

public class RandomLottoGenerator implements LottoGenerator {

    private static final int MIN_LOTTO_NUMBER = 1;
    private static final int MAX_LOTTO_NUMBER = 45;
    private static final int FIRST_COUNT = 0;
    private static final int LOTTO_NUMBER_COUNT = 6;

    private static final List<LottoNumber> LOTTO_NUMBERS = new ArrayList<>();

    static {
        IntStream.rangeClosed(MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER)
            .forEach(number -> LOTTO_NUMBERS.add(new LottoNumber(number)));
    }

    @Override
    public List<LottoNumber> get() {
        Collections.shuffle(LOTTO_NUMBERS);
        return new ArrayList<>(LOTTO_NUMBERS.subList(FIRST_COUNT, LOTTO_NUMBER_COUNT));
    }
}
