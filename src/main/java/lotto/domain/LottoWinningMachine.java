package lotto.domain;

import java.util.List;

public class LottoWinningMachine {

    private Lotto winnngLotto;

    public LottoWinningMachine(Lotto winnngLotto) {
        this.winnngLotto = winnngLotto;
    }

    public int checkCount(Lotto winningLotto, Lotto lotto) {
        int count = 0;

        List<LottoNumber> numbers = lotto.getNumbers();
        List<LottoNumber> winningNumbers = winningLotto.getNumbers();

        for (LottoNumber number : numbers) {
            if (winningNumbers.contains(number)) {
                count++;
            }
        }

        return count;
    }

}
