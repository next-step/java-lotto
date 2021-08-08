package lotto.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LottoNumbers {
    private static final int LOTTO_NUMBER_MIN_LENGTH = 0;
    private static final int LOTTO_NUMBER_MAX_LENGTH = 6;

    private List<Integer> lottoNumber;

    public LottoNumbers() {
        this.lottoNumber = new ArrayList<>();
    }

    public LottoNumbers(String numbers) {
        this.lottoNumber = Arrays.stream(numbers.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public LottoNumbers generateNumbers() {
        LottoNumber lottoNumber = new LottoNumber();
        lottoNumber.shuffle();
        this.lottoNumber = lottoNumber.getLottoNumber()
                .subList(LOTTO_NUMBER_MIN_LENGTH, LOTTO_NUMBER_MAX_LENGTH);
        return this;
    }

    public List<Integer> selectedNumber() {
        return this.lottoNumber;
    }
}
