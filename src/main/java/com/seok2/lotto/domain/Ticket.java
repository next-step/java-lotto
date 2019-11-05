package com.seok2.lotto.domain;

import static com.seok2.common.utils.StringUtils.LINE_BREAK;

import java.text.MessageFormat;

public class Ticket {

    private static final String PURCHASE_QUANTITY_MSG = "{0} 개를 구매했습니다.";

    private final Money purchaseAmount;
    private final Lotteries lotteries;


    private Ticket(Money purchaseAmount, Lotteries lotteries) {
        this.purchaseAmount = purchaseAmount;
        this.lotteries = lotteries;
    }

    public static Ticket of(Money purchaseAmount, Lotteries lotteries) {
        return new Ticket(purchaseAmount, lotteries);
    }

    public LottoResult check(Lotto winning) {
        return LottoResult.of(purchaseAmount, lotteries.check(winning));
    }

    public long size() {
        return lotteries.size();
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder(MessageFormat.format(PURCHASE_QUANTITY_MSG, lotteries.size()));
        builder.append(LINE_BREAK);
        for (Lotto lotto : lotteries) {
            builder.append(lotto)
                .append(LINE_BREAK);
        }
        return builder.toString();
    }
}
