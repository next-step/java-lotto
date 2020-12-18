package step2.domain;

import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RandomLottoNumber implements LottoNumber {
    private final static int INIT_NUMBER = 1;
    private final static int LIMITED_NUMBER = 45;
    public final static int LOTTO_NUMBERS_COUNT = 6;

    private List<Integer> numbers;

    public RandomLottoNumber() {
        initLottoNumbers();
    }

    private void initLottoNumbers() {
        this.numbers = IntStream.rangeClosed(INIT_NUMBER, LIMITED_NUMBER)
                .boxed().collect(Collectors.toList());
    }

    @Override
    public Set<Integer> getLottoNumbers() {
        Collections.shuffle(numbers);
        return numbers.stream()
                .limit(LOTTO_NUMBERS_COUNT)
                .collect(Collectors.toSet());
    }
}