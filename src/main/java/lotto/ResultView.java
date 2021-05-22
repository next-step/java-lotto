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
        System.out.println(resultAll.getResultThreeWon().getResult());
        System.out.println(resultAll.getResultFourWon().getResult());
        System.out.println(resultAll.getResultFiveWon().getResult());
        System.out.println(resultAll.getResultSixWon().getResult());
        printYield(resultAll, inputPurchaseAmount);
    }

    private void printYield(ResultAll resultAll, int inputPurchaseAmount) {
        float yield = calculateYield(resultAll, inputPurchaseAmount);
        System.out.println("총 수익률은 " + String.format("%.2f", yield) + "입니다.");
    }

    private float calculateYield(ResultAll resultAll, int inputPurchaseAmount) {
        return ((resultAll.getResultThreeWon().getWonMoney() +
                resultAll.getResultFourWon().getWonMoney() +
                resultAll.getResultFiveWon().getWonMoney() +
                resultAll.getResultSixWon().getWonMoney()) / inputPurchaseAmount);
    }
}
