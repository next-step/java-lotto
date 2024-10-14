package lotto.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoNumbers {
    public static final int LOTTO_NUMBER_COUNT = 6;
    public static final List<Integer> LOTTO_NUMBER_SET = IntStream.rangeClosed(1, 45).boxed().collect(Collectors.toList());
    private final List<Integer> lottoNumbers;

    private LottoNumbers(List<Integer> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public static LottoNumbers generate() {
        List<Integer> lottoNumberSet = new ArrayList<>(LOTTO_NUMBER_SET);

        Collections.shuffle(lottoNumberSet);
        return new LottoNumbers(lottoNumberSet.subList(0, LOTTO_NUMBER_COUNT));
    }

    public List<Integer> getLottoNumbers() {
        return new ArrayList<>(this.lottoNumbers);
    }
}
