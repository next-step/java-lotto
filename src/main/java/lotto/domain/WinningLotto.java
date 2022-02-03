package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class WinningLotto implements Lotto{

    private final List<Integer> numbers;
    private final Integer bonusNumber;

    public WinningLotto(List<Integer> numbers, Integer bonusNumber) {
        this.numbers = new ArrayList<>(numbers);
        this.bonusNumber = bonusNumber;
    }

    @Override
    public List<Integer> getLotto() {
        return numbers;
    }

    public Integer getBonusNumber() {
        return bonusNumber;
    }
}
