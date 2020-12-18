package step2;

public class Lotto {

    private LottoNumbers lottoNumbers;

    public Lotto(LottoNumbers lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public WinResult getWinResult(LottoNumbers lottoNumbers, LottoNumber bonusNumber) {
        return WinResult.valueOf(this.lottoNumbers.getMatchCount(lottoNumbers, bonusNumber));
    }

    @Override
    public String toString() {
        return lottoNumbers.toString();
    }
}
