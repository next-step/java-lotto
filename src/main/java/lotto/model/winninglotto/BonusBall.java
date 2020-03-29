package lotto.model.winninglotto;

public class BonusBall {
    private int bonusNumber;

    public BonusBall(int bonusNumber) {
        this.bonusNumber = bonusNumber;
    }

    public static BonusBall of(int bonusNumber){
        return new BonusBall(bonusNumber);
    }

    public boolean isEqualWith(int bonusNumber){
        return this.bonusNumber == bonusNumber;
    }
}
