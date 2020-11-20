package lotto.domain;

public class WinningLotto extends Lotto {
    private int bonusNumber;

    public WinningLotto(Numbers numbers, int bonusNumber) {
        super(numbers);
        this.bonusNumber = bonusNumber;
    }
}
