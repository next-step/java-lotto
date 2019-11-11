package com.seok2.lotto.domain.order;

import com.seok2.lotto.domain.common.Money;
import com.seok2.lotto.domain.lotto.Lotteries;
import com.seok2.lotto.domain.lotto.Lotto;
import com.seok2.lotto.domain.lotto.LottoStrategy;
import com.seok2.lotto.domain.lotto.LottoStrategyFactory;
import com.seok2.lotto.exception.PurchaseAmountException;
import java.util.ArrayList;
import java.util.List;

public class LottoMachine {

    public static Lotteries buy(Money investment, LottoSheet sheet) {
        List<Lotto> lotteries = new ArrayList<>();
        while (investment.moreThanOrEquals(Lotto.PRICE)) {
            LottoStrategy strategy = LottoStrategyFactory.get(sheet.next());
            lotteries.add(strategy.generate());
            investment = investment.subtract(Lotto.PRICE);
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
