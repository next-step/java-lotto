package lotto.domain;

import java.util.Collections;
import java.util.List;

public class Lotto {
    private List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        Collections.sort(numbers);
        this.numbers = numbers;
    }

    public WinningType findWinningType(List<Integer> others, int bonusNumber) {
       return WinningType.valueOf(countHits(others), matchBonus(bonusNumber));
    }

    private long countHits(List<Integer> others) {
        return others.stream()
                .filter(other -> numbers.contains(other))
                .count();
    }

    private boolean matchBonus(int bonusNumber) {
        return this.numbers.contains(bonusNumber);
    }

    @Override
    public String toString() {
        Collections.sort(numbers);
        return numbers + "";
    }
}
