package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class Lotto {
    public static final long PRICE = 1000L;

    private final LottoNumbers lottoNumbers;

    public Lotto(LottoNumbers lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public static Lotto auto() {
        return new Lotto(LottoNumbersGenerator.generate());
    }

    public List<Integer> getNumbers() {
        return lottoNumbers.getValue();
    }
}
