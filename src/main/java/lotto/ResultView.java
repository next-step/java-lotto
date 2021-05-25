package lotto;

public class ResultView {
    public void printPurchasedCount(int count) {
        System.out.println(count + "개를 구매했습니다.");
    }

    public void printPurchasedLottos(LottoNumberList lottoNumberList) {
        for (int i = 0; i < lottoNumberList.count(); i++) {
            System.out.println(lottoNumberList.get(i).getLottoNumbers());
        }
    }

    public void printLottoGameResult(ResultAll resultAll, int inputPurchaseAmount) {
        System.out.println("당첨 통계");
        System.out.println("--------");
        ResultScoreEnum.THREE.printResult(resultAll.getResult().get(ResultScoreEnum.THREE));
        ResultScoreEnum.FOUR.printResult(resultAll.getResult().get(ResultScoreEnum.FOUR));
        ResultScoreEnum.FIVE.printResult(resultAll.getResult().get(ResultScoreEnum.FIVE));
        ResultScoreEnum.SIX.printResult(resultAll.getResult().get(ResultScoreEnum.SIX));

        printYield(resultAll, inputPurchaseAmount);
    }

    private void printYield(ResultAll resultAll, int inputPurchaseAmount) {
        float yield = resultAll.yield(inputPurchaseAmount);
        System.out.println("총 수익률은 " + String.format("%.2f", yield) + "입니다.");
    }

}
