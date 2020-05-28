package com.lotto.view;

import com.lotto.domain.LottoWinningType;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Map;

public class LottoStatisticView {

    private static final String LOTTO_STATISTICS_TITLE = "당첨 통계";
    private static final String LOTTO_STATISTICS_SEPARATORS = "---------";
    private static final String CORRECT_MESSAGE_UNIT = "개";
    private static final String RATE_OF_RETURN_PREFIX = "총 수익률은 ";
    private static final String RATE_OF_RETURN_POSTFIX = "입니다.";
    private static final String ADDITIONAL_EXPLAIN_PREFIX = "(기준이 1이기 때문에 결과적으로 ";
    private static final String ADDITIONAL_EXPLAIN_POSTFIX = "라는 의미임)";
    private static final String DAMAGES = "손해";
    private static final String GAIN = "이득";

    public void viewLottoStatistic(Map<LottoWinningType, Integer> result) {
        System.out.println();
        System.out.println(LOTTO_STATISTICS_TITLE);
        System.out.println(LOTTO_STATISTICS_SEPARATORS);
        for (Map.Entry<LottoWinningType, Integer> entry : result.entrySet()) {
            LottoWinningType lottoWinningType = entry.getKey();

            StringBuilder messageBuilder = new StringBuilder()
                    .append(lottoWinningType.getMessage())
                    .append(entry.getValue())
                    .append(CORRECT_MESSAGE_UNIT);

            System.out.println(messageBuilder);
        }
    }

    public void viewRateOfReturn(Double rateOfReturn) {

        BigDecimal rate = new BigDecimal(rateOfReturn);
        String damagesOrGain = rateOfReturn > 1 ? GAIN : DAMAGES;

        StringBuilder messageBuilder = new StringBuilder()
                .append(RATE_OF_RETURN_PREFIX)
                .append(rate.setScale(2, RoundingMode.HALF_UP))
                .append(RATE_OF_RETURN_POSTFIX)
                .append(ADDITIONAL_EXPLAIN_PREFIX)
                .append(damagesOrGain)
                .append(ADDITIONAL_EXPLAIN_POSTFIX);

        System.out.println(messageBuilder);
    }
}
