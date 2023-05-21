package domain;

public class BonusNumber {
    private int bounsNumber;

    public BonusNumber(int bounsNumber) {
        this.bounsNumber = bounsNumber;
    }

    public boolean isBonusMatch(LottoNumber number) {
        return number.isSameNumber(bounsNumber);
    }
}
