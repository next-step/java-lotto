package com.seok2.lotto.domain;

import java.text.MessageFormat;

public class Profit {

    private static final String PROFIT_MSG = "총 수익률은 {0} 입니다.";
    private final double profit;

    public Profit(double profit) {
        this.profit = profit;
    }

    @Override
    public String toString() {
        return MessageFormat.format(PROFIT_MSG, profit);
    }
}
