package com.nextstep.lotto;

public class LottoSeller {
    private static final int LOTTO_PRICE = 1000;

    private LottoSeller(){}

    public static int count(int price) {
        return price / LOTTO_PRICE;
    }
}
