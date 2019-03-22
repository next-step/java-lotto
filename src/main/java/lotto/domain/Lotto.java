package lotto.domain;

public class Lotto {
    private LottoNumbers lottoNumbers;

    public Lotto(LottoNumbers lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public int size() {
        return lottoNumbers.size();
    }

    public int matchCount(WinningLotto winningLotto) {
        return lottoNumbers.matchCount(winningLotto);
    }

    public Winning prize(WinningLotto winningLotto) {
        return lottoNumbers.matchResult(winningLotto);
    }

    public Winning rank(WinningLotto winningLotto) {
        return lottoNumbers.matchResult(winningLotto);
    }
}
