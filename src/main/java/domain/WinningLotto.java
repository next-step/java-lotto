package domain;

public class WinningLotto {

    public static final int WINNING_LOTTO_COUNT = 1;

    private Lotto lotto;

    private LottoNumber bonusLottoNumber;

    public WinningLotto(Lotto lotto, LottoNumber lottoNumber) {
        this.lotto = lotto;
        this.bonusLottoNumber = lottoNumber;

        if (lotto.hasDuplicatedLottoNumber(lottoNumber)) {
            throw new IllegalArgumentException("중복된 번호를 보너스 번호에 입력할 수 없습니다.");
        }
    }

    public LottoNumbers getNumbers() {
        return lotto.getNumbers();
    }

    public LottoNumber getBonusNumber() {
        return this.bonusLottoNumber;
    }
}
