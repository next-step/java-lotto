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

    public void reportView(List<Lotto> lottos,List<LottoNumber> winnersNums) {
        int[] result = getMatchResult(lottos, winnersNums);
        statisticsView(result);
        rateOfReturnView(lottos, result);
    }

    private int[] getMatchResult(List<Lotto> lottos, List<LottoNumber> winnersNums) {
        int[] result = new int[7];
        for (Lotto lotto : lottos) {
            int match = lotto.match(winnersNums);
            result[match] += 1;
        }
        return result;
    }

    private void rateOfReturnView(List<Lotto> lottos, int[] result) {
        double rateOfReturn = rateOfReturn(result, lottos.size());
        DecimalFormat df = new DecimalFormat("0.00");
        System.out.println("총 수익률은 " + df.format(rateOfReturn) +"입니다.");
    }

    private void statisticsView(int[] result) {
        String sb = String.format("당첨 통계\n" +
                "---------\n" +
                "3개 일치 (5000원)- %d개\n" +
                "4개 일치 (50000원)- %d개\n" +
                "5개 일치 (1500000원)- %d개\n" +
                "6개 일치 (2000000000원)- %d개\n", result[3], result[4], result[5], result[6]);
        System.out.println(sb);
    }

    private double rateOfReturn(int[] result, int lottoNum){
        int income = result[3] * 5000 + result[4] * 50000 + result[5] * 1500000 + result[6] * 2000000000;
        int expenditure = lottoNum * 1000;
        return (double) income / expenditure;
    }

}
