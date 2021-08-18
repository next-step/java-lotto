package domain;

public class WinningLotto {

    private Lotto lotto;

    private BonusBall bonusBall;

    public WinningLotto(Lotto lotto, BonusBall bonusBall) {
        this.lotto = lotto;
        this.bonusBall = bonusBall;

        if (lotto.getNumbers().getValues().contains(bonusBall.getValue())) {
            throw new IllegalArgumentException("중복된 번호를 보너스 번호에 입력할 수 없습니다.");
        }
    }

    public LottoNumbers getNumbers() {
        return lotto.getNumbers();
    }

    public int getBonusNumber() {
        return bonusBall.getValue();
    }
}
