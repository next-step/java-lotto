package domain;

import java.util.Collections;
import java.util.List;

public class WinningLotto {

    private List<Integer> numbers;
    private int bonusNumber;

    public WinningLotto(List<Integer> numbers, int bonusNumber) {
        this.numbers = numbers;
        Collections.sort(numbers);
        this.bonusNumber = bonusNumber;
    }

    public LottoProfit match(Lotto userLotto) {
        int count = 0;

        for (int number : numbers) {
            count = count + addCount(userLotto, number);
        }

        if (count == (LottoProfit.THIRD.getNumberOfMatch() - 1) && contains(userLotto, bonusNumber)) {
            return LottoProfit.SECOND;
        }

        return LottoProfit.valueOf(count, false);
    }

    private int addCount(Lotto userLotto, int number) {
        if (contains(userLotto, number)) {
            return 1;
        }
        return 0;
    }

    private boolean contains(Lotto userLotto, int number) {
        return userLotto.contains(number);
    }

}
