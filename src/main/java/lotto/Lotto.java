package lotto;

import java.util.Collections;
import java.util.List;

public class Lotto {
    private List<Integer> lottoNumbers;

    public Lotto(List<Integer> lottoNumbers) {
        this.lottoNumbers = Collections.unmodifiableList(lottoNumbers);
    }
}
