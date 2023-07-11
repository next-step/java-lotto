package lottogame;

public class WinningNumber {

    private final Lotto winningLotto;
    private final LottoNumber bonusBall;

    public WinningNumber(String lottoValue, String bonusValue) {
        LottoText lottoText = new LottoText(lottoValue);
        Lotto lotto = new Lotto(lottoText.getParsed());
        LottoNumber lottoNumber = new LottoNumber(bonusValue);

        validate(lotto, lottoNumber);

        winningLotto = lotto;
        bonusBall = lottoNumber;
    }

    private void validate(Lotto lotto, LottoNumber lottoNumber) {
        if (lotto.hasLottoNumber(lottoNumber)) {
            throw new IllegalArgumentException("보너스볼이 당첨번호에 존재합니다");
        }
    }

    public Lotto getWinningLotto() {
        return winningLotto;
    }

    public LottoNumber getBonusBall(){
        return bonusBall;
    }
}
