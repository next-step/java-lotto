package lotto.domain;

public class Lotto {
    private final LottoNumbers lottoNumbers;

    public Lotto(LottoNumbers lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public LottoNumbers getLottoNumbers() {
        return this.lottoNumbers;
    }

    public int getCountOfMatchingNumber(LottoNumbers winningLottoNumbers) {
        return (int) this.lottoNumbers.getLottoNumbers().stream()
                .filter(winningLottoNumbers::contains)
                .count();
    }

    @Override
    public String toString() {
        return this.lottoNumbers.toString();
    }
}
