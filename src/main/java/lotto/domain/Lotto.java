package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class Lotto {

    private final LottoNumbers lottoNumbers;

    public Lotto(LottoNumbers numbers) {
        numbers.validateDigit();
        numbers.validateRange();
        this.lottoNumbers = numbers;
    }

    public int matchCount(List<Integer> winningNumbers) {
        int matchCount = 0;
        for (int number : winningNumbers) {
            if (lottoNumbers.isContain(number)) {
                ++matchCount;
            }
        }
        return matchCount;
    }
}
