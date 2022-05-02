package autolotto.domain;

public class WinningLotto {
    private LottoNumbers lottoNumbers;

    public WinningLotto(LottoNumbers lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public boolean contains(int number) {
        return lottoNumbers.contains(number);
    }
}
