package lotto;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoNumber {
    public static final int MAXIMUM_LOTTO_NUMBER = 45;
    public static final int MINIMUM_LOTTO_NUMBER = 1;

    private List<Integer> lottoNumbers;

    public LottoNumber() {
        lottoNumbers = shuffleNumbers(generateNumbers());
    }

    public List<Integer> getLottoNumbers() {
        return lottoNumbers.stream()
                .limit(6)
                .sorted()
                .collect(Collectors.toList());
    }

    private List<Integer> generateNumbers() {
        return IntStream
                .rangeClosed(MINIMUM_LOTTO_NUMBER, MAXIMUM_LOTTO_NUMBER)
                .boxed()
                .collect(Collectors.toList());
    }

    private List<Integer> shuffleNumbers(List<Integer> generatedNumber) {
        Collections.shuffle(generatedNumber);
        return new ArrayList<>(generatedNumber);
    }
}
