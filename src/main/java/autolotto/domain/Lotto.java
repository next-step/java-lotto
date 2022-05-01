package autolotto.domain;

public class Lotto {
    private LottoNumbers lottoNumbers;

    public Lotto(LottoNumbers lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public int match(WinningLotto winningLotto) {
        return lottoNumbers.match(winningLotto);
    }

    @Override
    public String toString() {
        return lottoNumbers.toString();
    }
}
