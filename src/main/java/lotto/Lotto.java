package lotto;

import java.util.List;

public class Lotto {

    private final List<Number> lottoNumbers;

    public Lotto(List<Number> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public List<Number> getLottoNumbers() {
        return lottoNumbers;
    }
}
