package com.fineroot.lotto.entity;

import com.fineroot.lotto.dto.Money;

public class LottoStore {

    private static final int LOTTO_PRICE = 1000;

    private Money purchasePrice;

    public LottoStore(){
        purchasePrice=Money.from(0);
    }

    public int howMuchLotto(){
        return purchasePrice.getValue() / LOTTO_PRICE;
    }

    public void preservePurchaseMoney(Money money){
        this.purchasePrice = money;
    }
}
