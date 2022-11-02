package com.nextlevel.kky.lotto.domain;

import com.nextlevel.kky.lotto.model.Lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoShop {

    private static final int LOTTO_PRICE = 1000;
    private final IntegerArrayGenerator integerArrayGenerator;

    public LottoShop(IntegerArrayGenerator integerArrayGenerator) {
        this.integerArrayGenerator = integerArrayGenerator;
    }

    public List<Lotto> buyLotto(int amount) {
        int count = amount / LOTTO_PRICE;
        List<Lotto> lottoList = new ArrayList<>(amount);
        for (int i = 0; i < count; i++) {
            lottoList.add(new Lotto(integerArrayGenerator.getIntegerArray()));
        }
        return lottoList;
    }
}
