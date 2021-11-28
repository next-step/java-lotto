package step2.domain;

import java.util.Collections;
import java.util.List;

public class Lotto {
    private List<Integer> lottoNumbers;

    Lotto(List<Integer> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public List<Integer> getLottoNumbers(){
        return Collections.unmodifiableList(lottoNumbers);
    }
}
