package lotto;

import java.text.DecimalFormat;
import java.util.*;

public class ResultView {

    public void lottoSizeResultView(int lottoNums) {
        System.out.println( lottoNums + "개를 구매했습니다.");
    }

    public void lottoNumbersView(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            System.out.println(lotto);
        }
    }

    public void reportView(LottoResult lottoResult) {
        statisticsView(lottoResult.matchCount(3),
                lottoResult.matchCount(4),
                lottoResult.matchCount(5),
                lottoResult.matchCount(6));
        rateOfReturnView(lottoResult.calculateRateOfReturn());
    }


    private void rateOfReturnView(String rateOfReturn) {
        System.out.println("총 수익률은 " + rateOfReturn +"입니다.");
    }

    private void statisticsView(int match3,int match4, int match5, int match6) {
        String sb = String.format("당첨 통계\n" +
                "---------\n" +
                "3개 일치 (5000원)- %d개\n" +
                "4개 일치 (50000원)- %d개\n" +
                "5개 일치 (1500000원)- %d개\n" +
                "6개 일치 (2000000000원)- %d개\n", match3, match4, match5, match6);
        System.out.println(sb);
    }

}
