package lotto;

import java.util.Set;

public class BonusBall {

    private int bonusNumber;

    public BonusBall(int bonusNumber) {
        this.bonusNumber = bonusNumber;
    }

    public void checkBonusBallValidation(Set<Integer> winnerLottery) {
        if(winnerLottery.contains(this.bonusNumber)) {
            throw new IllegalArgumentException();
        }
    }
}
