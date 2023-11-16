package lotto.domain;

public class Lotto {
    private LottoNumbers lottoNumbers;

    public Lotto() {
        this.lottoNumbers = new LottoNumbers();
    }

    public Lotto(final LottoNumbers lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    int getRightNumber(LottoNumbers winningNumbers) {
        return lottoNumbers.getRightNumber(winningNumbers);
    }

    boolean contains(final int bonusNumber) {
        return lottoNumbers.contains(bonusNumber);
    }

    @Override
    public String toString() {
        return lottoNumbers.toString();
    }
}
