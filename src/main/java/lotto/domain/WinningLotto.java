package lotto.domain;

public class WinningLotto {
    private Lotto winningLotto;
    private LottoNumber lottoNumber;

    public WinningLotto(Lotto winningLotto, LottoNumber lottoNumber) {
        if (winningLotto.contains(lottoNumber)) {
            throw new IllegalArgumentException("보너스 번호는 로또번호와 중복한 번호일 수 없다.");
        }
        this.winningLotto = winningLotto;
        this.lottoNumber = lottoNumber;
    }

    public int getMatchCount(Lotto lotto) {

        return winningLotto.getLottoNumbers().getMatchCount(lotto);
    }

    public boolean isBonusMatch(Lotto lotto) {

        return lotto.contains(lottoNumber);
    }
}
