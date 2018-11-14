package lotto.ui;

import lotto.domain.LottoResultSet;
import lotto.domain.LottoSet;

import java.math.BigDecimal;
import java.text.MessageFormat;

public class ResultView {

    private ResultView() {

    }

    public static void printLottoSet(LottoSet lottoSet) {
        System.out.println(MessageFormat.format("{0}개를 구입했습니다.", lottoSet.size()));
        System.out.println(lottoSet);
        System.out.println();
    }

    public static void printLottoResultSet(LottoResultSet lottoResultSet) {
        System.out.println("당첨 통계");
        System.out.println("---------");
        System.out.println(lottoResultSet);
    }

    public static void printRateReturn(BigDecimal rateReturn) {
        System.out.println(MessageFormat.format("총 수익률을 {0}입니다.", rateReturn));
    }
}
