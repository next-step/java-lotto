package lotto.domain;

import java.util.List;

public class Lotto {
    private final List<LottoNumber> lottoNumberList;

    private Lotto(List<LottoNumber> lottoNumberList) {
        this.lottoNumberList = lottoNumberList;
    }

    public static Lotto generateByManual(List<Integer> numberList) {
        return new Lotto(null);
    }

    public static Lotto generateByAuto() {
        return new Lotto(null);
    }

    public List<LottoNumber> getLottoNumberList() {
        return lottoNumberList;
    }
}
