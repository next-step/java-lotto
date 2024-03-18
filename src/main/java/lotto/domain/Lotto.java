package lotto.domain;

import java.util.List;

public class Lotto {

    private final LottoNumbers lottoNumbers;
    private final int PRICE = 1000;

    public Lotto(List<Integer> lottoNumbers) {
        this.lottoNumbers = new LottoNumbers(lottoNumbers);
    }
}
