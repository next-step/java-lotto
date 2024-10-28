package lotto.domain;

import java.util.List;

public class WinningLotto extends Lotto{

    private int bonusNumber;
    public WinningLotto(List<Integer> numbers,int bonusNumber) {
        super(numbers);
        this.bonusNumber=bonusNumber;
    }

    public boolean hasBonusNumber(Lotto lotto){
        return lotto.containNumber(bonusNumber);
    }
}
