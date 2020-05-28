package com.lotto.domain;

import java.util.List;

public class Lotto {

    private List<Integer> extractedLottoNumbers;
    private Integer matchingCount;

    public Lotto(List<Integer> extractedLottoNumbers, Integer matchingCount) {
        this.extractedLottoNumbers = extractedLottoNumbers;
        this.matchingCount = matchingCount;
    }

    public Integer getNumberOfMatchingWithWinningNumber(List<Integer> winningNumbers) {
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

    public List<Integer> getExtractedLottoNumbers() {
        return this.extractedLottoNumbers;
    }

    @Override
    public String toString() {
        return this.extractedLottoNumbers.toString();
    }
}
