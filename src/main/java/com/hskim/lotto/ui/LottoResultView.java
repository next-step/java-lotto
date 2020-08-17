package com.hskim.lotto.ui;

import com.hskim.lotto.model.EarningRate;
import com.hskim.lotto.model.LottoWinTable;

import java.util.Map;
import java.util.stream.Collectors;

public class LottoResultView {
    private static final String PURCHASE_NUMBER_PHRASE = "개를 구매했습니다.";
    private static final String STATISTIC_PHRASE = "당첨 통계";
    private static final String NEW_LINE = System.lineSeparator();
    private static final String UNDER_LINE = "================";
    private static final String EARNING_RATE_PHRASE = "총 수익률은 ";
    private static final String END_PHRASE = "입니다.";
    private static final String LOSS_ALERT_MESSAGE = "(기준이 " + (int) EarningRate.STANDARD_RATE
            + "이기 때문에 결과적으로 손해라는 의미임)";
    private static final String STATISTIC_STRING_JOINING_DELIMITER = "\n";
    private static final String HYPHEN = "-";
    private static final String NUM_PHRASE = "개";

    public void printEarningRate(String earningRate, boolean isProfit) {
        String phrase = EARNING_RATE_PHRASE + earningRate + END_PHRASE;

        if (isProfit) {
            System.out.println(phrase);
            return;
        }

        System.out.println(phrase + LOSS_ALERT_MESSAGE);
    }

    public void printString(String string) {
        System.out.println(string);
    }

    public void printPurchaseNum(int purchaseNum) {
        System.out.println(purchaseNum + PURCHASE_NUMBER_PHRASE);
    }

    public void printStatisticResult(Map<LottoWinTable, Integer> winnerMap) {
        System.out.println();
        System.out.println(STATISTIC_PHRASE
                + NEW_LINE
                + UNDER_LINE
                + NEW_LINE
                + winnerMap.keySet()
                .stream()
                .map(lottoWinTable -> makeDataString(lottoWinTable, winnerMap))
                .collect(Collectors.joining(STATISTIC_STRING_JOINING_DELIMITER))
        );
    }

    private String makeDataString(LottoWinTable lottoWinTable, Map<LottoWinTable, Integer> winnerMap) {
        return lottoWinTable.toString()
                + HYPHEN
                + winnerMap.get(lottoWinTable)
                + NUM_PHRASE;
    }
}
