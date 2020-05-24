package com.lotto.domain;

import java.util.List;

public class Lotto {

    private List<Integer> extractedLottoNumbers;
    private Integer matchingCount;

    public Lotto(List<Integer> extractedLottoNumbers) {
        this.extractedLottoNumbers = extractedLottoNumbers;
    }

    private Integer getNumberMatchingWithWinningNumber(List<Integer> winningNumbers) {
        for (Integer extractedLottoNumber : this.extractedLottoNumbers) {
            increaseMatchingCount(winningNumbers, extractedLottoNumber);
        }

        return this.matchingCount;
    }

    private void increaseMatchingCount(List<Integer> winningNumbers, Integer targetNumber) {
        if (winningNumbers.contains(targetNumber)) {
            this.matchingCount++;
        }
    }

    @Override
    public String toString() {
        return this.extractedLottoNumbers.toString();
    }
}
