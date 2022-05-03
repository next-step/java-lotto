package autolotto.domain;

public class WinningLotto {
    private LottoNumbers lottoNumbers;
    private int bonusBall;

    public WinningLotto(LottoNumbers lottoNumbers) {
        this(lottoNumbers, 0);
    }

    public WinningLotto(LottoNumbers lottoNumbers, int bonusBall) {
        this.lottoNumbers = lottoNumbers;
        this.bonusBall = bonusBall;
    }

    public boolean contains(int number) {
        return lottoNumbers.contains(number);
    }

    public int getBonusBall() {
        return bonusBall;
    }
}
