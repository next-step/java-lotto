package lottoauto;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoNumbers {
    private static final int LOTTO_NUMBER_START = 1;
    private static final int LOTTO_NUMBER_END = 45;
    private static final int ZERO = 0;
    private static final int LOTTO_NUMBER_SIZE = 6;

    private final List<Integer> lottoNumbers;

    public LottoNumbers() {
        this.lottoNumbers = generateLottoNumbers();
    }

    private List<Integer> generateLottoNumbers() {
        List<Integer> lottoNumberList = IntStream.rangeClosed(LOTTO_NUMBER_START, LOTTO_NUMBER_END)
                .boxed()
                .collect(Collectors.toList());
        Collections.shuffle(lottoNumberList);

        return lottoNumberList.subList(ZERO,LOTTO_NUMBER_SIZE);
    }

    public boolean isNonDuplicate() {
        return new HashSet<>(lottoNumbers).size() == LOTTO_NUMBER_SIZE;
    }

    public boolean isBetween1To45() {
        return !lottoNumbers.stream()
                .anyMatch(lottoNumber -> lottoNumber < LOTTO_NUMBER_START || lottoNumber > LOTTO_NUMBER_END);
    }
}
