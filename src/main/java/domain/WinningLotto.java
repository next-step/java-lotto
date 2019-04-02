package domain;

import java.util.Collections;
import java.util.List;

public class WinningLotto {

    List<Integer> numbers;
    int bonusNumber;

    public WinningLotto(List<Integer> numbers, int bonusNumber) {
        this.numbers = numbers;
        Collections.sort(numbers);
        this.bonusNumber = bonusNumber;
    }

    public LottoProfit match(Lotto userLotto) {
        int count = 0;

        for (int number : numbers) {
            if (contains(userLotto, number)) count++;
        }

        if (count == (LottoProfit.THIRD.getNumberOfMatch() - 1) && contains(userLotto, bonusNumber)) {
            return LottoProfit.SECOND;
        }

        return LottoProfit.valueOf(count, false);
    }

    private boolean contains(Lotto userLotto, int number) {
        return userLotto.contains(number);
    }

}
