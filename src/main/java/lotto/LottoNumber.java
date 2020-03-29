package lotto;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoNumber {
    public static final int MAXIMUM_LOTTO_NUMBER = 45;
    public static final int MINIMUM_LOTTO_NUMBER = 1;

    private List<Integer> lottoNumbers;

    public LottoNumber() {
        lottoNumbers = generateNumbers();
    }

    private List<Integer> generateNumbers() {
        return IntStream
                .rangeClosed(MINIMUM_LOTTO_NUMBER, MAXIMUM_LOTTO_NUMBER)
                .boxed()
                .collect(Collectors.toList());
    }

    private void shuffleNumber() {
        Collections.shuffle(lottoNumbers);
    }

    public List<Integer> getLottoNumbers() {
        shuffleNumber();

        return lottoNumbers.stream()
                .filter(lottoNumberCount -> lottoNumberCount <= 6)
                .collect(Collectors.toList());
    }
}
