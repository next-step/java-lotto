package lotto.domain;

import java.util.List;

public class Lotto {
    public static final int SIZE = 6;
    public static final int PRICE = 1000;

    private List<LottoNumber> value;

    public Lotto(List<LottoNumber> lottoNumbers) {
        this.value = lottoNumbers;
    }
}
