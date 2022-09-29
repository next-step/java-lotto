package lotto.domain;

import java.util.List;

public class Lotto {
    public static final int SIZE = 6;

    private List<LottoNumber> value;

    public Lotto(List<LottoNumber> lottoNumbers) {
        this.value = lottoNumbers;
    }
}
