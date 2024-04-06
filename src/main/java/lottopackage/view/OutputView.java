package lottopackage.view;

import lottopackage.domain.Lotto;
import lottopackage.domain.Prize;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class OutputView {

    /* Method */
    public static void printLottoGroup(List<Lotto> lottoGroup) {
        for (int i = 0; i < lottoGroup.size(); i++ ) {
            List<Integer> lotto = lottoGroup.get(i).getLotto();
            System.out.println(lotto);
        }
    }

    public static void printLottoResult(List<Prize> lottoResult, int totalLottoGroupSize) {
        List<Prize> prizeGroup = Arrays.asList( Prize.values() );
        int totalWinningAmount = 0;

        System.out.println("당첨 통계");
        System.out.println("--------");

        for( int i = 0; i < prizeGroup.size(); i++) {
            System.out.println(prizeGroup.get(i).getBall() + "개 일치 ("
                    + prizeGroup.get(i).getWinningAmount() + "원)- "
                    + Collections.frequency(lottoResult, prizeGroup.get(i)) + "개");
            totalWinningAmount += (prizeGroup.get(i).getWinningAmount()) * (Collections.frequency(lottoResult, prizeGroup.get(i)));
        }

        System.out.println("총 수익률은" + (float)totalWinningAmount / (totalLottoGroupSize * 1000) + "입니다.");
    }
}
