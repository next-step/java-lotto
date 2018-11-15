package lotto.domain;

import lotto.utils.CollectionUtils;

import java.util.List;

public class WinningLotto {

    private List<Integer> numbers;
    private int bonusNumber;

    private WinningLotto(List<Integer> numbers, int bonusNumber) {
        this.numbers = numbers;
        this.bonusNumber = bonusNumber;
    }

    public static WinningLotto create(List<Integer> numbers, int bonusNumber) {
        return new WinningLotto(numbers, bonusNumber);
    }

    public List<Integer> getNumbers(){
        return this.numbers;
    }

    public List<Integer> getNumbersWithBonus(){
        return CollectionUtils.merge(this.numbers, this.bonusNumber);
    }
}
