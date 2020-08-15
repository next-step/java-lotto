package lotto.ui;

import common.StringResources;
import lotto.domain.LottoResult;

public class ResultView {

    public static final String REPLACE_TARGET = "##";

    public static void print(String str) {
        System.out.println(str);
    }

    public static void printLottoResult(LottoResult lottoResult) {
        System.out.println(StringResources.MSG_LOTTO_RESULT[0].replace(REPLACE_TARGET, String.valueOf(lottoResult.getWinningCount(3))));
        System.out.println(StringResources.MSG_LOTTO_RESULT[1].replace(REPLACE_TARGET, String.valueOf(lottoResult.getWinningCount(4))));
        System.out.println(StringResources.MSG_LOTTO_RESULT[2].replace(REPLACE_TARGET, String.valueOf(lottoResult.getWinningCount(5))));
        System.out.println(StringResources.MSG_LOTTO_RESULT[3].replace(REPLACE_TARGET, String.valueOf(lottoResult.getWinningCount(6))));
    }

    public static void printLottoEarningsRate(LottoResult lottoResult) {
        System.out.println(StringResources.MSG_EARNINGS_RATE.replace(REPLACE_TARGET, String.valueOf(lottoResult.getEarningsRate())));
    }
}
