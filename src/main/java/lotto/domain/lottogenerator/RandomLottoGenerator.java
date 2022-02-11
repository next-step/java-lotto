package lotto.domain.lottogenerator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import lotto.domain.Lotto;
import lotto.domain.LottoNumber;

public class RandomLottoGenerator implements LottoGenerator {

    private static final int MIN_LOTTO_NUMBER = 1;
    private static final int MAX_LOTTO_NUMBER = 45;
    private static final int FIRST_COUNT = 0;
    private static final int LOTTO_SIZE = 6;

    private static final List<Integer> LOTTO_NUMBERS = new ArrayList<>();

    static {
        IntStream.rangeClosed(MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER)
            .forEach(LOTTO_NUMBERS::add);
    }

    @Override
    public Lotto get() {
        Collections.shuffle(LOTTO_NUMBERS);
        List<Integer> numbers = new ArrayList<>(LOTTO_NUMBERS.subList(FIRST_COUNT, LOTTO_SIZE));
        List<LottoNumber> lottoNumbers = numbers.stream().map(LottoNumber::from).collect(Collectors.toList());
        return Lotto.of(lottoNumbers);
    }
}
