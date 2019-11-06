package com.seok2.lotto.view;

import static com.seok2.common.utils.StringUtils.LINE_BREAK;

import com.seok2.lotto.domain.Lotteries;
import com.seok2.lotto.domain.Lotto;
import com.seok2.lotto.domain.Rank;
import com.seok2.lotto.domain.Ranks;
import java.text.MessageFormat;

public class LottoOutputView {

    private static final String PURCHASE_QUANTITY_MSG = "{0} 개를 구매했습니다.";
    private static final String RESULT_TITLE = "당첨 통계 \n----------------------";
    private static final String RESULT_RANK_MSG = "{0} - {1} 개";
    private static final String RESULT_YIELD_MSG = "총 수익률은 {0}입니다.";

    private LottoOutputView() {
    }

    public static void print(Lotteries lotteries) {
        StringBuilder builder = new StringBuilder(MessageFormat.format(PURCHASE_QUANTITY_MSG, lotteries.size()));
        builder.append(LINE_BREAK);
        for (Lotto lotto : lotteries) {
            builder.append(lotto)
                .append(LINE_BREAK);
        }
        System.out.println(builder.toString());
    }


    public static void print(Ranks ranks) {
        StringBuilder builder = new StringBuilder(RESULT_TITLE)
            .append(LINE_BREAK);
        for (Rank rank : Rank.WINNINGS) {
            builder.append(MessageFormat.format(RESULT_RANK_MSG, rank, ranks.count(rank)))
                .append(LINE_BREAK);
        }
        builder.append(MessageFormat.format(RESULT_YIELD_MSG, ranks.calculateYield()));
        System.out.println(builder.toString());
    }
}
