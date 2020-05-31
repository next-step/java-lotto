package step2.domain;

import java.util.List;

public abstract class AbstractLotto {

    private List<Integer> lottoNumbers;

    public List<Integer> getLottoNumbers() {
        return this.lottoNumbers;
    }

    public void setLottoNumbers(List<Integer> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }
}
