package domain;

import java.util.List;

public class Lotto {
    private List<Integer> numbers;

    public static Lotto generateLotto(List<Integer> integers) {
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
        int matchCount = count < 3 ? 2 : count;
        return LottoResultStatus.of(matchCount);
    }

    public List<Integer> getNumbers() {
       return this.numbers;
    }

}
