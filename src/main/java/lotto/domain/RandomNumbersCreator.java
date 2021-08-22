package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RandomNumbersCreator implements LottoNumbersCreator {

    private static final int COUNT = 6;
    private static final List<LottoNumber> numbers = IntStream.rangeClosed(LottoNumber.MIN_NUMBER, LottoNumber.MAX_NUMBER)
            .boxed()
            .map(LottoNumber::new)
            .collect(Collectors.toList());

    private static RandomNumbersCreator randomNumbersCreator = null;

    private RandomNumbersCreator(){}

    public static RandomNumbersCreator getInstance() {
        if (randomNumbersCreator == null) {
            randomNumbersCreator = new RandomNumbersCreator();
        }
        return randomNumbersCreator;
    }

    @Override
    public List<LottoNumber> createNumbers() {
        Collections.shuffle(numbers);
        List<LottoNumber> result = new ArrayList<>(numbers.subList(0, COUNT));
        Collections.sort(result);
        return result;
    }
}
