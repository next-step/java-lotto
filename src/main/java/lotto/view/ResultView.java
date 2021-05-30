package lotto.view;

import lotto.domain.LottoNumbersList;
import lotto.domain.ResultAllLottoScores;
import lotto.domain.ResultScoreEnum;

public class ResultView {
    public void printPurchasedCount(int count) {
        System.out.println(count + "개를 구매했습니다.");
    }

    public void printPurchasedLottos(LottoNumbersList lottoNumbersList) {
        lottoNumbersList.foreach((x) -> System.out.println(x.getLottoNumbers()));
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
        System.out.println("총 수익률은 " + String.format("%.2f", yield) + "입니다.");
    }

}
