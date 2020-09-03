package lotto.domain;

public class BonusBall {
    private final LottoNum bonusNum;

    public BonusBall(String bonusNumber) {
        this.bonusNum = new LottoNum(Integer.parseInt(bonusNumber));
    }

    public int getBonusNumber() {
        return bonusNum.getLottoNum();
    }
}
