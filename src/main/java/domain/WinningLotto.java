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

    public int match(Lotto userLotto) {
        int count = 0;

        for (int number : numbers) {
            if (contains(userLotto, number)) count++;
        }

        if (contains(userLotto, bonusNumber)) {
            count++;
        }
        return count;
    }

    private boolean contains(Lotto userLotto, int number) {
        return userLotto.contains(number);
    }

}
