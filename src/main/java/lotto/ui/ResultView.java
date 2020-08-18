package lotto.ui;

import java.util.Map.Entry;

import common.StringResources;
import lotto.domain.LottoResult;
import lotto.domain.Rank;
import lotto.domain.WinningCountMap;

public class ResultView {

    public static final String REPLACE_TARGET = "##";

    public static void print(String str) {
        System.out.println(str);
    }

    public static void printLottoResult(LottoResult lottoResult) {

        WinningCountMap winningCountMap = lottoResult.getWinningCountMap();

        int i = 0;
        for (Entry<Rank, Integer> entry : winningCountMap.getAllData().entrySet()) {
            System.out.println(StringResources.MSG_LOTTO_RESULT[i++].replace(
                    REPLACE_TARGET,
                    String.valueOf(entry.getValue())));
        }
    }

    public static void printLottoEarningsRate(LottoResult lottoResult) {
        System.out.println(StringResources.MSG_EARNINGS_RATE.replace(REPLACE_TARGET, String.valueOf(lottoResult.calculateEarningsRate())));
    }
}
