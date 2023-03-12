package lotto.domain;

import java.util.List;

public class LottoNumber {
    private final List<Integer> lottoNumberList;

    public LottoNumber(List<Integer> lottoNumberList) {
        this.lottoNumberList = lottoNumberList;
    }

    public List<Integer> getLottoNumber() {
        return lottoNumberList;
    }
}
