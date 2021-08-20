package lotto;

import util.Number;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lotto {
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;
    private static final int START_INDEX = 0;
    private static final int END_INDEX = 6;
    private static final List<Integer> availableNumbers = Number.rangeNumber(MIN_NUMBER, MAX_NUMBER);

    private final LottoNumbers lottoNumbers;

    public Lotto() {
        Collections.shuffle(availableNumbers);
        lottoNumbers = new LottoNumbers(new ArrayList<>(availableNumbers.subList(START_INDEX, END_INDEX)));
        lottoNumbers.sort();
    }

    public Lotto(List<Integer> lottoNumbers) {
        this.lottoNumbers = new LottoNumbers(lottoNumbers);
    }

    public int findMatchedNumberCount(List<Integer> prevWinningLottoNumbers) {
        int result = 0;
        for (int number : prevWinningLottoNumbers) {
            result = checkSame(result, number);
        }
        return result;
    }

    private int checkSame(int result, int number) {
        if (findSameNumber(number)) {
            result++;
        }
        return result;
    }

    private boolean findSameNumber(int prevWinningLottoNumbers) {
        return lottoNumbers.contains(prevWinningLottoNumbers);
    }

    @Override
    public String toString() {
        return lottoNumbers.toString();
    }

}
