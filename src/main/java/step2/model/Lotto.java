package step2.model;

import java.util.*;

public class Lotto {
    private List<Integer> lottoNumbers;

    public Lotto(LottoStrategy lottoStrategy) {
        this.lottoNumbers = lottoStrategy.getNumbers();
    }

    public List<Integer> getLottoNumbers() {
        return lottoNumbers;
    }

}
