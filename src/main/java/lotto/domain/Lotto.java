package lotto.domain;

import java.util.Collections;
import java.util.List;

public class Lotto {
    private List<Integer> lottoNumbers;
    private int countWinning = 0;

    public Lotto(List<Integer> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public final List<Integer> getLottoNumbers() {
        return Collections.unmodifiableList(lottoNumbers);
    }

    public int countWinningNumber(List<Integer> winningNumbers) {
        for (int lottoNumber : lottoNumbers) {
            addIfEqualWinningNumber(lottoNumber, winningNumbers);
        }
        return countWinning;
    }

    private int addIfEqualWinningNumber(int lottoNumber, List<Integer> winningNumbers) {
        for (int winningNumber : winningNumbers) {
            countWinning += getNumberIfEqual(lottoNumber, winningNumber);
        }
        return countWinning;
    }

    private int getNumberIfEqual(int lottoNumber, int winningNumber) {
        if (lottoNumber == winningNumber) {
            return 1;
        }
        return 0;
    }
}
