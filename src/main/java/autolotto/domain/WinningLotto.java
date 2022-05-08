package autolotto.domain;

public class WinningLotto {
    private final LottoNumbers lottoNumbers;
    private final LottoNumber bonusBall;

    public WinningLotto(LottoNumbers lottoNumbers) {
        this(lottoNumbers, null);
    }

    public WinningLotto(LottoNumbers lottoNumbers, LottoNumber bonusBall) {
        this.lottoNumbers = lottoNumbers;
        this.bonusBall = bonusBall;
    }

    public boolean contains(LottoNumber number) {
        return lottoNumbers.contains(number);
    }

    public LottoNumber getBonusBall() {
        return bonusBall;
    }
}
