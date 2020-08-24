package com.hskim.lotto.ui;

import com.google.common.collect.ImmutableMap;
import com.hskim.lotto.model.EarningRate;
import com.hskim.lotto.model.LottoWinTable;

import java.util.Map;
import java.util.stream.Collectors;

public class LottoResultView {
    private static final String MANUAL_PHRASE = "수동으로";
    private static final String AUTO_PHRASE = "자동으로";
    private static final String PURCHASE_NUMBER_PHRASE = "를 구매했습니다.";
    private static final String STATISTIC_PHRASE = "당첨 통계";
    private static final String NEW_LINE = System.lineSeparator();
    private static final String UNDER_LINE = "================";
    private static final String EARNING_RATE_PHRASE = "총 수익률은";
    private static final String END_PHRASE = "입니다.";
    private static final String LOSS_ALERT_MESSAGE = "(기준이 " + (int) EarningRate.STANDARD_RATE
            + "이기 때문에 결과적으로 손해라는 의미임)";
    private static final String STATISTIC_STRING_JOINING_DELIMITER = "\n";
    private static final String HYPHEN = " - ";
    private static final String SHEET_PHRASE = "장";
    private static final String NUM_PHRASE = "개";
    private static final String A_COMMA = ",";
    private static final String A_BLANK = " ";
    private static final String OPENING_BRACKET = "(";
    private static final String CLOSING_BRACKET = ")";
    private static final String THE_WON = "원";

    private static final Map<LottoWinTable, String> winMessageMap = ImmutableMap.of(
            LottoWinTable.FIRST_PLACE, "6개 일치",
            LottoWinTable.SECOND_PLACE, "5개 일치, 보너스 볼 일치",
            LottoWinTable.THIRD_PLACE, "5개 일치",
            LottoWinTable.FOURTH_PLACE, "4개 일치",
            LottoWinTable.FIFTH_PLACE, "3개 일치"
    );

    public void printEarningRate(String earningRate, boolean isProfit) {
        String phrase = EARNING_RATE_PHRASE + A_BLANK + earningRate + END_PHRASE;

        if (isProfit) {
            System.out.println(phrase);
            return;
        }

        System.out.println(phrase + LOSS_ALERT_MESSAGE);
    }

    public void printString(String string) {
        System.out.println(string);
    }

    public void printPurchaseNum(int manualPurchaseNum, int autoPurchaseNum) {
        System.out.println(NEW_LINE
                + MANUAL_PHRASE
                + A_BLANK
                + manualPurchaseNum
                + SHEET_PHRASE
                + A_COMMA
                + A_BLANK
                + AUTO_PHRASE
                + A_BLANK
                + autoPurchaseNum
                + NUM_PHRASE
                + PURCHASE_NUMBER_PHRASE);
    }

    public void printStatisticResult(Map<LottoWinTable, Integer> winnerMap) {
        System.out.println(NEW_LINE
                + STATISTIC_PHRASE
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
        return winMessageMap.get(lottoWinTable)
                + A_BLANK
                + OPENING_BRACKET
                + lottoWinTable.getPrizeAmount()
                + THE_WON
                + CLOSING_BRACKET
                + HYPHEN
                + winnerMap.get(lottoWinTable)
                + NUM_PHRASE;
    }
}
