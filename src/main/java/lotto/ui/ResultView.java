package lotto.ui;

import lotto.domain.LottoResultSet;
import lotto.domain.LottoSet;
import lotto.domain.Money;

import java.text.MessageFormat;

public class ResultView {

    private ResultView() {

    }

    public static void printLottoSet(LottoSet lottoSet) {
        System.out.println();
        System.out.println(MessageFormat.format("수동으로 {0}개, 자동으로 {1}개를 구매했습니다.", lottoSet.sizeOfManual(), lottoSet.sizeOfAutomatic()));
        System.out.println(lottoSet);
        System.out.println();
    }

    public static void printLottoResultSet(LottoResultSet lottoResultSet) {
        System.out.println("당첨 통계");
        System.out.println("---------");
        System.out.println(lottoResultSet);
    }

    public static void printRateReturn(Money money, int reward) {
        System.out.println(MessageFormat.format("총 수익률을 {0}입니다.", money.rateReturn(reward)));
    }
}
