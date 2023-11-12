package lotto.domain;

import java.util.List;

public class Lotto {
    private LottoNumbers lottoNumbers;

    public Lotto() {
        this.lottoNumbers = new LottoNumbers();
    }

    int getRightNumber(List<Integer> winningNumbers) {
        int rightNumber = 0;

        for (int winningNumber : winningNumbers) {
            rightNumber = plusRightNumber(rightNumber, winningNumber);
        }

        return rightNumber;
    }

    private int plusRightNumber(int rightNumber, final int winningNumber) {
        if (lottoNumbers.isRight(winningNumber)) {
            rightNumber++;
        }
        return rightNumber;
    }

    @Override
    public String toString() {
        return lottoNumbers.toString();
    }
}
