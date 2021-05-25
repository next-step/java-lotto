package lotto;

public class ResultView {
    public void printPurchasedCount(int count) {
        System.out.println(count + "개를 구매했습니다.");
    }

    public void printPurchasedLottos(LottoNumbersList lottoNumbersList) {
        for (int i = 0; i < lottoNumbersList.count(); i++) {
            System.out.println(lottoNumbersList.get(i).getLottoNumbers());
        }
    }

    public void printLottoGameResult(ResultAll resultAll, int inputPurchaseAmount) {
        System.out.println("당첨 통계");
        System.out.println("--------");
        ResultScoreEnum.FIFTH.printResult(resultAll.getResult().get(ResultScoreEnum.FIFTH));
        ResultScoreEnum.FOURTH.printResult(resultAll.getResult().get(ResultScoreEnum.FOURTH));
        ResultScoreEnum.THIRD.printResult(resultAll.getResult().get(ResultScoreEnum.THIRD));
        ResultScoreEnum.SECOND.printResult(resultAll.getResult().get(ResultScoreEnum.SECOND));
        ResultScoreEnum.FIRST.printResult(resultAll.getResult().get(ResultScoreEnum.FIRST));

        printYield(resultAll, inputPurchaseAmount);
    }

    private void printYield(ResultAll resultAll, int inputPurchaseAmount) {
        float yield = resultAll.yield(inputPurchaseAmount);
        System.out.println("총 수익률은 " + String.format("%.2f", yield) + "입니다.");
    }

}
