package lotto.domain;

public class WinningLottoNumber extends LottoPaper{

    private int bonusNumber;

    public WinningLottoNumber(String winningNumber) {
        super(winningNumber);
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    public void setBonusNumber(String bonusBall) {
        int bonusNumber = checkWinningNumber(bonusBall);

        if (getLottoNumber().contains(bonusNumber)) {
            throw new IllegalArgumentException("보너스 번호가 로또 당첨번호에 포함되면 안됩니다.");
        }
        this.bonusNumber = bonusNumber;
    }

}
