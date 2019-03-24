package domain;

import java.util.List;

public class LottoNumbers {
    private List<Integer> lottoNumbers;

    public LottoNumbers(List<Integer> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public boolean isContains(int winningNumber) {
        return this.lottoNumbers.contains(winningNumber);
    }

    @Override
    public String toString() {
        return lottoNumbers.toString();
    }
}
