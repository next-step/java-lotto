package lotto.domain.lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class NumberGenerator {
    public static final int START_NUMBER = 1;
    public static final int END_NUMBER = 45;

    public static final int START_LOTTO_RANGE = 0;
    public static final int END_LOTTO_RANGE = 6;

    private final List<Integer> numbers;

    private NumberGenerator() {
        List<Integer> numbers = IntStream.rangeClosed(START_NUMBER, END_NUMBER)
                .boxed()
                .collect(Collectors.toList());
        this.numbers = numbers;
    }

    public static NumberGenerator create() {
        return new NumberGenerator();
    }

    public List<LottoNumber> createLottoNumbers() {
        Collections.shuffle(numbers);
        List<LottoNumber> lottoLottoNumbers = new ArrayList<>(numbers.subList(START_LOTTO_RANGE, END_LOTTO_RANGE)
                .stream()
                .map(k -> LottoNumber.create(k))
                .collect(Collectors.toList()));
        Collections.sort(lottoLottoNumbers);
        return lottoLottoNumbers;
    }
}
