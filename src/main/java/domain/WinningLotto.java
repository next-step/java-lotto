package domain;

import java.util.Collections;
import java.util.List;

public class WinningLotto {

    List<Integer> numbers;

    public WinningLotto(List<Integer> numbers) {
        this.numbers = numbers;
        Collections.sort(numbers);
    }

    public int match(Lotto userLotto) {
        int count = 0;
        for(int number : numbers) {
            if (contains(userLotto, number)) count++;
        }
        return count;
    }

    private boolean contains(Lotto userLotto, int number) {
        return userLotto.contains(number);
    }

}
