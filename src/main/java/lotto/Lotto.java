package lotto;


public class Lotto {

    private LottoNumbers lottoNumbers;

    public Lotto(LottoNumbers lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public LottoNumbers getNumbers() {
        return lottoNumbers;
    }

    public LottoResult match(LottoNumbers winningLottoNumbers) {
        return new LottoResult(lottoNumbers.matchNumberCount(winningLottoNumbers));
    }

}
