package step2.domain;

import java.util.List;

public class Lotto {
    private LottoNumbers lottoNumbers;

    private Lotto() {
        lottoNumbers = LottoNumbers.create();
    }

    private Lotto(String[] splitNumbers) {
        lottoNumbers = LottoNumbers.of(splitNumbers);
    }

    public static Lotto generate() {
        return new Lotto();
    }

    public static Lotto of(String[] splitNumbers) {
        return new Lotto(splitNumbers);
    }

    public List<Number> getLottoNumbers() {
        return lottoNumbers.getNumbers();
    }
}
