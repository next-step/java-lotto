package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class WholeLottoNumbers {
    private List<Number> lottoNumberList;

    public WholeLottoNumbers() {
        lottoNumberList = new ArrayList<>();
    }

    public void createNumber() {
        for (int i = 1; i < 46; i++) {
            lottoNumberList.add(new Number(i));
        }
    }

    public List<Number> lottoNumberList() {
        return this.lottoNumberList;
    }
}
