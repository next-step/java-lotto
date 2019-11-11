package com.seok2.lotto.view;

import static com.seok2.common.utils.StringUtils.LINE_BREAK;

import com.seok2.lotto.domain.lotto.Lotteries;
import com.seok2.lotto.domain.lotto.Lotto;
import com.seok2.lotto.domain.rank.Rank;
import com.seok2.lotto.domain.rank.Ranks;
import java.text.MessageFormat;

public class LottoOutputView {

    private static final String PURCHASE_QUANTITY_MSG = "수동으로 {0} 장, 자동으로 {1} 장을를 구매했습니다.";
    private static final String ONLY_AUTO_PURCHASE_QUANTITY_MSG = "자동으로 {0} 장을 구매했습니다.";
    private static final String ONLY_MANUAL_PURCHASE_QUANTITY_MSG = "수동으로 {0} 장을 구매했습니다.";
    private static final String RESULT_TITLE = "당첨 통계 \n----------------------";
    private static final String RESULT_RANK_MSG = "{0} - {1} 개";
    private static final String RESULT_YIELD_MSG = "총 수익률은 {0}입니다.";

    private LottoOutputView() {
    }

    public static void print(Lotteries lotteries) {
        StringBuilder builder = new StringBuilder(makeQuantityMsg(lotteries));
        builder.append(LINE_BREAK);
        for (Lotto lotto : lotteries) {
            builder.append(lotto)
                .append(LINE_BREAK);
        }
        System.out.println(builder.toString());
    }

    private static String makeQuantityMsg(Lotteries lotteries) {
        long sizeOfAuto = lotteries.sizeOfAuto();
        long sizeOfManual = lotteries.sizeOfManual();
        if (sizeOfManual != 0 && sizeOfAuto != 0) {
            return MessageFormat.format(PURCHASE_QUANTITY_MSG, sizeOfManual, sizeOfAuto);
        }
        if (sizeOfManual == 0) {
            return MessageFormat.format(ONLY_AUTO_PURCHASE_QUANTITY_MSG, sizeOfAuto);
        }
        return MessageFormat.format(ONLY_MANUAL_PURCHASE_QUANTITY_MSG, sizeOfManual);
    }


    public static void print(Ranks ranks) {
        StringBuilder builder = new StringBuilder(RESULT_TITLE)
            .append(LINE_BREAK);
        for (Rank rank : Rank.WINNINGS) {
            builder.append(MessageFormat.format(RESULT_RANK_MSG, rank, ranks.count(rank)))
                .append(LINE_BREAK);
        }
        builder.append(MessageFormat.format(RESULT_YIELD_MSG, ranks.calculateReturnOnInvestmentRate()));
        System.out.println(builder.toString());
    }
}