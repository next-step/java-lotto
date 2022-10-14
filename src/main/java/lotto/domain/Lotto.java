package lotto.domain;

public class Lotto {

    private final LottoNumberSet lottoNumbers;

    public Lotto() {
        this(LottoNumberSet.createLottoNumberSet());
    }

    public Lotto(LottoNumberSet lottoNumberSet) {
        this.lottoNumbers = lottoNumberSet;
    }

    public int rank(Lotto lotto) {
        int match = lottoNumbers.match(lotto.numbers());
        if (match == 3) {
            return 5;
        }
        if (match == 4) {
            return 4;
        }
        if (match == 5) {
            return 3;
        }
        if (match == 6) {
            return 1;
        }
        return 0;
    }

    private LottoNumberSet numbers() {
        return this.lottoNumbers;
    }

    @Override
    public String toString() {
        return String.format("[%s]", lottoNumbers.toString());
    }
}
