package lotto.domain;

import java.util.Collections;
import java.util.List;

public class Lotto {

    private final List<Integer> lottoNumbers;

    private Lotto(List<Integer> lottoNumbers) {
        this.lottoNumbers = Collections.unmodifiableList(lottoNumbers);
    }
    public static Object of(List<Integer> lottoNumbers) {
        return new Lotto(lottoNumbers);
    }

}
