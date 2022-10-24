package domain;

public class BonusNumber {

    private final Integer bonusNumber;

    public BonusNumber(String number) {
        this.bonusNumber = Integer.parseInt(number);
    }

    public static BonusNumber from(String input) {
        return new BonusNumber(input);
    }

    public Integer getBonusNumber() {
        return bonusNumber;
    }

}
