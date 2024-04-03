package lottopackage.view;

import lottopackage.domain.Lotto;
import lottopackage.domain.Prize;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class OutputView {
    
    public void printLottoGroup(List<Lotto> lottoGroup) {
        for (int i = 0; i < lottoGroup.size(); i++ ) {
            List<Integer> lotto = lottoGroup.get(i).getLottoNumber();
            System.out.println("[" + lotto.get(0) + ", " + lotto.get(1) + ", "+ lotto.get(2) + ", "
                    + lotto.get(3) + ", "+ lotto.get(4) + ", "+ lotto.get(5) + "]");
        }
    }

    public void printLottoResult(List<Prize> lottoResult, int totalLottoGroupSize) {
        List<Prize> prizeGroup = Arrays.asList( Prize.values() );
        int totalWinningAmount = 0;

        System.out.println("당첨 통계");
        System.out.println("--------");

        for( int i = 0; i < prizeGroup.size(); i++) {
            System.out.println(prizeGroup.get(i).same + "개 일치 ("
                    + prizeGroup.get(i).winningAmount + "원)- "
                    + Collections.frequency(lottoResult, prizeGroup.get(i)) + "개");
            totalWinningAmount += prizeGroup.get(i).winningAmount;
        }

        System.out.println("총 수익률은" + totalWinningAmount/totalLottoGroupSize + "입니다.");
    }
}
