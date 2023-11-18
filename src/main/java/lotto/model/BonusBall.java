package lotto.model;

public class BonusBall {
    private final PositiveNumber bonusNumber;

    public BonusBall(PositiveNumber bonusNumber) {
        this.bonusNumber = bonusNumber;
    }
    public PositiveNumber bonus(){
        return this.bonusNumber;
    }
    public int number(){
        return this.bonusNumber.number();
    }
}
