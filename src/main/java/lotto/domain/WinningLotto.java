package lotto.domain;

public class WinningLotto {
    private LottoNumbers lottoNumbers;

    public WinningLotto(LottoNumbers lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public int size() {
        return lottoNumbers.size();
    }

    public boolean contains(Integer number) {
        return lottoNumbers.contains(number);
    }
}
