package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoNumberList {

    final static int LOTTO_MAX_NUM = 45;
    final static int LOTTO_SELECT_NUM = 6;

    List<Integer> lottoNumberList;

    public LottoNumberList() {
        List<Integer> lottoNumberList = new ArrayList<>();
        for (int i = 1; i <= LOTTO_MAX_NUM; i++) {
            lottoNumberList.add(i);
        }
        this.lottoNumberList = lottoNumberList;
    }
}
