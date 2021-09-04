package step2;

public class Lotto {

    private final LottoNumbers lottoNumbers;

    public Lotto() {
        this.lottoNumbers = new LottoNumbers();
    }

    @Override
    public String toString() {
        return lottoNumbers.toString();
    }
}
