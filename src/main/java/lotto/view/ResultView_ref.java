package lotto.view;

import lotto.domain.LottoNumbersList_ref;
import lotto.domain.ResultAllLottoScores_ref;
import lotto.domain.ResultScoreEnum_ref;

public class ResultView_ref {
    public void printPurchasedCount(int count) {
        System.out.println(count + "개를 구매했습니다.");
    }

    public void printPurchasedLottos(LottoNumbersList_ref lottoNumbersListRef) {
        lottoNumbersListRef.foreach((x) -> System.out.println(x.getLottoNumbers()));
    }

    public void printLottoGameResult(ResultAllLottoScores_ref resultAllLottoScoresRef, int inputPurchaseAmount) {
        System.out.println("당첨 통계");
        System.out.println("--------");
        ResultScoreEnum_ref resultScoreEnumRef[] = ResultScoreEnum_ref.values();
        for (ResultScoreEnum_ref state : resultScoreEnumRef) {
            state.printResult(resultAllLottoScoresRef.result().get(state));
        }

        printYield(resultAllLottoScoresRef, inputPurchaseAmount);
    }

    private void printYield(ResultAllLottoScores_ref resultAllLottoScoresRef, int inputPurchaseAmount) {
        float yield = resultAllLottoScoresRef.yield(inputPurchaseAmount);
        System.out.println("총 수익률은 " + String.format("%.2f", yield) + "입니다.");
    }

}
