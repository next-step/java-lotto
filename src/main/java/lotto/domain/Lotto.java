package lotto.domain;

import java.util.List;

public class Lotto {

    private LottoNumbers lottoNumbers;

    public Lotto(List<Integer> list) {
        this.lottoNumbers = new LottoNumbers(list);
    }

    public List<Integer> getLottoNumbers() {
        return lottoNumbers.getLottoNumbers();
    }

}
