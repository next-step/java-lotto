package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class Lotto {

    private final LottoNumbers lottoNumbers;
    private int matchCount;

    public Lotto(LottoNumbers numbers) {
        matchCount = 0;
        numbers.validateDigit();
        numbers.validateRangeOfNumbers();
        this.lottoNumbers = numbers;
    }

    public int matchCount(WinningNumbers winningNumbers) {
        for (int number : winningNumbers.winningNumbers) {
            matchCount = getMatchCount(number);
        }
        return matchCount;
    }

    private int getMatchCount(int number) {
        if (lottoNumbers.isContain(number)) {
            ++matchCount;
        }
        return matchCount;
    }

    @Override
    public String toString() {
        return this.lottoNumbers.toString();
    }
}
