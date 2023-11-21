package com.fineroot.lotto.entity;

import com.fineroot.lotto.dto.LottoBundleStatus;
import com.fineroot.lotto.dto.Money;
import com.fineroot.lotto.dto.WinningNumber;
import com.fineroot.lotto.util.LottoUtils;

public class LottoStore {
    private LottoBundle lottoBundle;

    public LottoStore() {
        lottoBundle = LottoBundle.from(0);
    }

    public int howMuchLotto(Money money) {
        return getLotteryCount(money);
    }

    public void purchaseLottery(Money money) {
        lottoBundle = LottoBundle.from(getLotteryCount(money));
    }

    private int getLotteryCount(Money money) {
        return money.getValue() / LottoUtils.LOTTO_EACH_PRICE;
    }

    public LottoBundleStatus lottoBundleStatus() {
        return lottoBundle.toLottoBundleStatus();
    }

    public WinnerStatus winnerStatus(WinningNumber winningNumber) {
        return lottoBundle.matchWinner(winningNumber);
    }
}
