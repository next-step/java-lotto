package lotto.domains;

public class Lotto {

    private final LottoNumbers lottoNumbers;

    public Lotto(){
        lottoNumbers = new LottoNumbers();
    }

    public Lotto(LottoNumbers lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public int matchingNumberCount(LottoNumbers winningNumber) {
        return this.lottoNumbers.matchingNumberCount(winningNumber);
    }

    public LottoNumbers lottoNumbers() {
        return lottoNumbers;
    }
}
