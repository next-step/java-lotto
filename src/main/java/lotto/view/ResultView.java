package lotto.view;

import lotto.domain.*;

public class ResultView {
    public void printPurchasedCount(int manualCount, int autoCount, LottoNumbersList lottoNumbersList) {
        System.out.println("수동으로 " + manualCount + "장, 자동으로 " + autoCount + "개를 구매했습니다.");
        lottoNumbersList.foreach((x) -> System.out.println(x.showLottoNoList()));
    }

    public void printLottoGameResult(ResultAllLottoScores resultAllLottoScores, int inputPurchaseAmount) {
        System.out.println("당첨 통계");
        System.out.println("--------");
        ResultScoreEnum resultScoreEnum[] = ResultScoreEnum.values();
        for (ResultScoreEnum state : resultScoreEnum) {
            state.printResult(resultAllLottoScores.result().get(state));
        }

        printYield(resultAllLottoScores, inputPurchaseAmount);
    }

    private void printYield(ResultAllLottoScores resultAllLottoScores, int inputPurchaseAmount) {
        float yield = resultAllLottoScores.yield(inputPurchaseAmount);
        System.out.println("총 수익률은 " + String.format("%.2f", yield) + "입니다. (기준이 1이기 떄문에 결과적으로 손해라는 의미임)");
    }
}
