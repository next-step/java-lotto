package lotto;

import java.util.ArrayList;
import java.util.List;

public class Lotto {
    private static final int AVAILABLE_MIN_NUMBER = 1;
    private static final int AVAILABLE_MAX_NUMBER = 45;
    private static final int MIN_LENGTH = 0;
    private static final int MAX_LENGTH = 6;
    private static final AvailableNumbers availableNumbers = new AvailableNumbers(AVAILABLE_MIN_NUMBER, AVAILABLE_MAX_NUMBER);

    private final LottoNumbers lottoNumbers;

    public Lotto() {
        availableNumbers.shuffle();
        lottoNumbers = new LottoNumbers(new ArrayList<>(availableNumbers.subList(MIN_LENGTH, MAX_LENGTH)));
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
