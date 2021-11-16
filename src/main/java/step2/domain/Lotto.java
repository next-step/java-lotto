package step2.domain;

import java.util.List;

public class Lotto {
    private LottoNumbers lottoNumbers;

    private Lotto() {
        lottoNumbers = LottoNumbers.create();
    }

    public static Lotto generate() {
        return new Lotto();
    }

    public List<Number> getLottoNumbers() {
        return lottoNumbers.getNumbers();
    }
}
