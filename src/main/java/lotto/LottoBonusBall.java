package lotto;

import lotto.Lotto;

public class LottoBonusBall {

    private int number;

    public LottoBonusBall(int number){
        this.number = number;
    }

    public boolean isExistBonusBall(Lotto lotto){
        return lotto.getNumber().contains(this.number);
    }
}
