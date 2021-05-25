package lotto.view;

import lotto.LottoResult;
import lotto.Lottos;

public class ResultView {
    private static final String FIRST_RANK = "6개 일치 (2000000000원)- %d개\n";
    private static final String SECOND_RANK = "5개 일치 (1500000원)- %d개\n";
    private static final String THIRD_RANK = "4개 일치 (50000원)- %d개\n";
    private static final String FOURTH_RANK = "3개 일치 (5000원)- %d개\n";
    private static final String PROFIT = "총 수익률은 %d입니다.";
    private static final String REMARK = "(기준이 1이기 때문에 결과적으로 손해라는 의미임)";

    public ResultView() {

    }

    public static void buyLottoInfo(Lottos lottos) {
        System.out.println(lottos.toString());
    }

    public static void prinfResult(LottoResult lottoResult) {
        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("---------");
        System.out.printf(FIRST_RANK, lottoResult.getCountFristLotto());
        System.out.printf(SECOND_RANK, lottoResult.getCountSecondLotto());
        System.out.printf(THIRD_RANK, lottoResult.getCountThirdLotto());
        System.out.printf(FOURTH_RANK, lottoResult.getCountFourthLotto());
        long profit = lottoResult.getProfit();
        System.out.printf(PROFIT, profit);
        if(profit < 1){
            System.out.print(REMARK);
        }
    }
}
