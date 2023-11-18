package lotto.domain;

import lotto.exception.NotNumberRangeException;

import java.util.ArrayList;
import java.util.List;

public class LottoWinNumbers {
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;

    private List<Integer> winningLottoNumbers;

    public LottoWinNumbers(List<Integer> winningLottoNumbers) {
        validateNumberRange(winningLottoNumbers);
        this.winningLottoNumbers = new ArrayList<>(winningLottoNumbers);
    }

    private void validateNumberRange(List<Integer> numbers) {
        if (!isNumberRange(numbers)) {
            throw new NotNumberRangeException();
        }
    }

    private boolean isNumberRange(List<Integer> numbers) {
        return numbers.stream()
                .allMatch(number -> number >= MIN_NUMBER && number <= MAX_NUMBER);
    }

    public LottoRank matchCount(List<Integer> lottoNumbers, BonusBall bonusBall) {
        long matchCount = lottoNumbers.stream()
                .filter(winningLottoNumbers::contains)
                .count();

        return LottoRank.of(matchCount, bonusBall.containsBonusBall(lottoNumbers));
    }
}
