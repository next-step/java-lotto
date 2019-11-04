package com.seok2.lotto.domain;

import java.util.List;

public class Lotteries {

    private List<Lotto> lotteries;

    protected Lotteries(List<Lotto> lotteries) {
        validate(lotteries);
        this.lotteries = lotteries;
    }

    private void validate(List<Lotto> lotteries) {
        if (lotteries.isEmpty())
            throw new IllegalArgumentException("최소 한 장 이상의 게임을 구매해야 합니다.");
    }

    protected int size() {
        return lotteries.size();
    }


}
