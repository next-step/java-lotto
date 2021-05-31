package lotto.domains;

public class WinningLotto {
    private final Lotto winningLotto;
    private final LottoNumber bonusNumber;

    public WinningLotto(Lotto winningLotto, int bonusNumber) {
        this.winningLotto = winningLotto;
        this.bonusNumber = LottoNumber.of(bonusNumber);
    }

    public WinningLotto(String stringWinningNumbers, int bonusNumber) {
        LottoNumbers lottoNumber = new LottoNumbers(stringWinningNumbers);
        LottoNumber bonusLottoNumber = LottoNumber.of(bonusNumber);
        validateBonusNumberInWinningLottoNumber(lottoNumber, bonusLottoNumber);
        this.winningLotto = new Lotto(new LottoNumbers(stringWinningNumbers));
        this.bonusNumber = bonusLottoNumber;

    }

    public WinningLotto(LottoNumbers winningLottoNumber, int bonusNumber) {
        LottoNumber bonusLottoNumber = LottoNumber.of(bonusNumber);
        validateBonusNumberInWinningLottoNumber(winningLottoNumber, bonusLottoNumber);
        this.winningLotto = new Lotto(winningLottoNumber);
        this.bonusNumber = bonusLottoNumber;
    }

    private void validateBonusNumberInWinningLottoNumber(LottoNumbers lottoNumber, LottoNumber bonusNumber) {
        if (lottoNumber.contains(bonusNumber)) {
            throw new IllegalArgumentException("당첨번호에 없는 보너스번호를 입력해주세요.");
        }
    }

    public LottoNumbers winningNumbers() {
        return this.winningLotto.lottoNumbers();
    }

    public LottoNumber bonusNumber() {
        return bonusNumber;
    }
}
