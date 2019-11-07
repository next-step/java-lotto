package com.seok2.lotto.domain;

import com.seok2.lotto.exception.PurchaseAmountException;
import java.util.ArrayList;
import java.util.List;

public class LottoMachine {

    public static Lotteries buy(Money investment, LottoSheet sheet) {
        Money lottoPrice = Lotto.LOTTO_PRICE;
        List<Lotto> lotteries = new ArrayList<>();
        while (investment.moreThanOrEquals(lottoPrice)) {
            LottoStrategy strategy = LottoStrategyFactory.get(sheet.next());
            lotteries.add(strategy.generate());
            investment = investment.subtract(lottoPrice);
        }
        checkLottoSheet(sheet);
        return Lotteries.of(lotteries);
    }

    private static void checkLottoSheet(LottoSheet sheet) {
        if (sheet.isNotEmpty()) {
            throw new PurchaseAmountException();
        }
    }

}
