package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Lotto {
    private List<Integer> lottoNumbers = new ArrayList<>(6);
    private Random random = new Random();

    public Lotto() {
        Collections.shuffle(lottoNumbers, random);
    }

    public Lotto(List<Integer> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public final List<Integer> getLottoNumbers() {
        return Collections.unmodifiableList(lottoNumbers);
    }

    public int countWinningNumber(List<Integer> winningNumber) {
        int result = 0;
        for (int index = 0; index < 6; index++) {
            result += addIfEqualWinningNumber(index, winningNumber);
        }
        return result;
    }

    private int addIfEqualWinningNumber(int index, List<Integer> winningNumber) {
        if (lottoNumbers.get(index).equals(winningNumber.get(index))) {
            return 1;
        }
        return 0;
    }
}
