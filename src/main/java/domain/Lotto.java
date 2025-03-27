package domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lotto {

    private final int LOTTO_NUMBER_BOUND = 45;
    private final int REQUIRED_NUMBER_COUNT = 6;

    private final List<Integer> numbers;
    private final List<Integer> lottoNumbers;

    public Lotto() {
        this.numbers = IntStream.rangeClosed(1, LOTTO_NUMBER_BOUND).boxed().collect(Collectors.toList());
        this.lottoNumbers = auto();
    }

    public List<Integer> getLottoNumbers() {
        return lottoNumbers;
    }

    private List<Integer> auto() {

        Collections.shuffle(numbers);

        List<Integer> lottoNumbers = numbers.subList(0, REQUIRED_NUMBER_COUNT);

        Collections.sort(lottoNumbers);

        return lottoNumbers;
    }
}
