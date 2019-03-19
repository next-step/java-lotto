package domain;

import java.util.ArrayList;
import java.util.List;

public class Lotto {
    private List<Integer> numbers;

    public static Lotto generateLotto(ArrayList<Integer> integers) {
        Lotto lotto = new Lotto();
        lotto.numbers = integers;
        return lotto;
    }

    public LottoResultStatus getLottoResultStatus(int[] winningNumbers) {
        int containsWinningNumberCount = 0;
        for(int number : winningNumbers) {
            if(numbers.contains(number))
                containsWinningNumberCount ++;
        }

        return setResultByContainCount(containsWinningNumberCount);
    }

    private LottoResultStatus setResultByContainCount(int count) {
        if (count < 3) {
            return LottoResultStatus.NONE;
        }

        if (count == 3) {
            return LottoResultStatus.WINNING_NUM_3;
        }

        if (count == 4) {
            return LottoResultStatus.WINNING_NUM_4;
        }

        if (count == 5) {
            return LottoResultStatus.WINNING_NUM_5;
        }

        if (count == 6) {
            return LottoResultStatus.WINNING_NUM_6;
        }

        return null;
    }

    public List<Integer> getNumbers() {
       return this.numbers;
    }

    @Override
    public String toString() {
        return "Lotto{" +
                "numbers=" + numbers +
                '}';
    }
}
