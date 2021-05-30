package lotto.domains;

public class WinningLotto {
    private final Lotto winningLotto;
    private final int bonusNumber;

    public WinningLotto(Lotto winningLotto, int bonusNumber) {
        this.winningLotto = winningLotto;
        this.bonusNumber = bonusNumber;
    }

    public WinningLotto(String stringWinningNumbers, int bonusNumber) {
        LottoNumbers lottoNumber = new LottoNumbers(stringWinningNumbers);
        validateBonusNumberInWinningLottoNumber(lottoNumber, bonusNumber);
        this.winningLotto = new Lotto(new LottoNumbers(stringWinningNumbers));
        this.bonusNumber = bonusNumber;

    }

    public WinningLotto(LottoNumbers winningLottoNumber, int bonusNumber) {
        validateBonusNumberInWinningLottoNumber(winningLottoNumber, bonusNumber);
        this.winningLotto = new Lotto(winningLottoNumber);
        this.bonusNumber = bonusNumber;
    }

    private void validateBonusNumberInWinningLottoNumber(LottoNumbers lottoNumber, int bonusNumber) {
        if (lottoNumber.contains(bonusNumber)) {
            throw new IllegalArgumentException("당첨번호에 없는 보너스번호를 입력해주세요.");
        }
    }

    public LottoNumbers winningNumbers() {
        return this.winningLotto.lottoNumbers();
    }

    public int bonusNumber() {
        return bonusNumber;
    }
}
