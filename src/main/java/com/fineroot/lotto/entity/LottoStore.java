package com.fineroot.lotto.entity;

import com.fineroot.lotto.dto.LottoBundleStatus;
import com.fineroot.lotto.dto.Money;

public class LottoStore {

    private static final int LOTTO_PRICE = 1000;

    private LottoBundle lottoBundle;
    public LottoStore(){
        lottoBundle = LottoBundle.from(0);
    }

    public int howMuchLotto(Money money){
        return getLotteryCount(money);
    }

    public void purchaseLottery(Money money){
        lottoBundle = LottoBundle.from(getLotteryCount(money));
    }

    private int getLotteryCount(Money money) {
        return money.getValue() / LOTTO_PRICE;
    }

    public LottoBundleStatus lottoBundleStatus(){
        return lottoBundle.toLottoBundleStatus();
    }
}
