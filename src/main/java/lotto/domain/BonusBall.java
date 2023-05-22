package lotto.domain;

public class BonusBall {
    private final Integer bonusBall;

    private BonusBall(Integer bonusBall) {
        this.bonusBall = bonusBall;
    }

    public static BonusBall from(String bonusBall) {
        return new BonusBall(Integer.valueOf(bonusBall));
    }

    public Integer getBonusBall() {
        return bonusBall;
    }
}
