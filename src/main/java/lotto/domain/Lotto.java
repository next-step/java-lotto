package lotto.domain;

import java.util.List;

public class Lotto {

    private final LottoNumbers lottoNumbers;

    public Lotto(List<Integer> generatedNumbers) {
        this.lottoNumbers = new LottoNumbers(generatedNumbers);
    }
}
