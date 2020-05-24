package com.lotto.view;

import com.lotto.domain.LottoWinningType;

import java.util.Map;

public class LottoStatisticView {

    private static final String LOTTO_STATISTICS_TITLE = "당첨 통계";
    private static final String LOTTO_STATISTICS_SEPARATORS = "---------";
    private static final String CORRECT_MESSAGE = "개 일치 (";
    private static final String CORRECT_MESSAGE_SEPARATORS = ")- ";
    private static final String CORRECT_MESSAGE_UNIT = "개";

    public void viewLottoStatistic(Map<LottoWinningType, Integer> result) {
        System.out.println();
        System.out.println(LOTTO_STATISTICS_TITLE);
        System.out.println(LOTTO_STATISTICS_SEPARATORS);
        for (Map.Entry<LottoWinningType, Integer> entry : result.entrySet()) {
            LottoWinningType lottoWinningType = entry.getKey();
            Integer matchingCount = lottoWinningType.getMatchingCount();

            StringBuilder messageBuilder = new StringBuilder()
                    .append(matchingCount)
                    .append(CORRECT_MESSAGE)
                    .append(lottoWinningType.getWinningAmount())
                    .append(CORRECT_MESSAGE_SEPARATORS)
                    .append(entry.getValue())
                    .append(CORRECT_MESSAGE_UNIT);

            System.out.println(messageBuilder);
        }
    }
}
