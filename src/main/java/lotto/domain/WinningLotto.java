package lotto.domain;

public class WinningLotto {
    private Lotto lotto;
    private LottoNumber lottoNumber;

    public WinningLotto(Lotto lotto, LottoNumber lottoNumber) {
        if (lotto.contains(lottoNumber)) {
            throw new IllegalArgumentException("보너스 번호는 로또번호와 중복한 번호일 수 없다.");
        }
        this.lotto = lotto;
        this.lottoNumber = lottoNumber;
    }

    public Lotto getWinningLotto() {
        return lotto;
    }

    public LottoNumber getBonusLottoNumber() {
        return lottoNumber;
    }
}
