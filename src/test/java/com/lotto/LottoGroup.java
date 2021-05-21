package com.lotto;

import java.util.List;

public class LottoGroup {
    private List<Lotto> lottoList;

    public LottoGroup(List<Lotto> lottoList) {
        this.lottoList = lottoList;
    }

    public int size() {
        return lottoList.size();
    }
}
