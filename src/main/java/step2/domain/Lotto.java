package step2.domain;

import java.util.List;

public class Lotto {

    private final List<Integer> lottoNumbers;

    public Lotto(List<Integer> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;

    }
    public List<Integer> getLottoNumbers() {
        return lottoNumbers;
    }
}
