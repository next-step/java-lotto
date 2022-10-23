package lotto.domain;

import java.util.List;

import static lotto.util.NumberUtil.makeAutoNumberList;

public class LottoNumbers {

    private final List<Integer> lottoNumberList;

    public LottoNumbers() {
        this(makeAutoNumberList());
    }

    public LottoNumbers(List<Integer> lottoNumberList) {
        this.lottoNumberList = lottoNumberList;
    }

    public List<Integer> getLottoNumberList() {
        return lottoNumberList;
    }
}
