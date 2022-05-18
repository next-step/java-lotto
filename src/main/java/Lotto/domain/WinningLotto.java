package Lotto.domain;

import Lotto.exception.SameNumberException;

import java.util.List;

public class WinningLotto extends Lotto {

    private Number bonusNumber;

    public WinningLotto(List<Integer> numbers) {
        super(numbers);
    }

    public WinningLotto(String winningNumbers) {
        super(winningNumbers);
    }

    public WinningLotto(String winningNumberStr, Number bonusNumber) {
        this(winningNumberStr);

        this.bonusNumber = bonusNumber;

        isDuplicateNumber();
    }

    private void isDuplicateNumber() {
        if(number.contains(bonusNumber)) {
            throw new SameNumberException("당첨번호와 보너스 번호가 중복됩니다.");
        }
    }

    public List<Number> getList() {
        return this.number;
    }

    public Number getBonusNumber() { return bonusNumber; }
}
