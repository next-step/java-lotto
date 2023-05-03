package lotto;

import java.util.List;

public class Lotto {

    private final List<Integer> lottoNumbers;

    public Lotto() {
        lottoNumbers = LottoFactory.create();
    }

    public List<Integer> getLottoNumbers() {
        return this.lottoNumbers;
    }
}
