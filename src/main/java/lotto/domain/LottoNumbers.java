package lotto.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LottoNumbers {

    private final List<Integer> lottoNumbers;

    public LottoNumbers() {
        List<Integer> seedNumbers = new ArrayList<>();
        for (int i = 0; i < 45; ++i) {
            seedNumbers.add(i + 1);
        }
        Collections.shuffle(seedNumbers);
        this.lottoNumbers = seedNumbers.subList(0, 6);
    }

    public LottoNumbers(Integer... numbers) {
        lottoNumbers = new ArrayList<>();
        lottoNumbers.addAll(Arrays.asList(numbers));
    }

    void validateDigit() {
        if (this.lottoNumbers.size() != 6) {
            throw new IllegalArgumentException("로또는 숫자 6개로 구성되어야 합니다.");
        }
    }
}
