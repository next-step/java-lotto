package view;

import model.*;

public class ResultView {
    public void printLottos(Lottos lottos) {
        System.out.printf("%d개를 구매했습니다\n", lottos.count());
        for (int i = 0; i < lottos.count(); i++) {
            System.out.println(lottos.get(i).numbers());
        }
    }

    public void printResult(LottoResult result) {
        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("---------");


        for (Placement placement: Placement.values()) {
            printPlacementStat(result, placement);
        }

        Yield lottoResultYield = Yield.of(result.totalPrize(), result.totalInvestment());
        printYield(lottoResultYield);
        System.out.println();
    }

    private void printYield(Yield lottoYield) {
        System.out.printf("총 수익률은 %.0f입니다.(기준이 1이기 때문에 결과적으로 %s라는 의미임)", lottoYield.valueOf(), lottoYield.verdictInKorean());
    }

    public void printPlacementStat(LottoResult result, Placement placement) {
        int matchingCount = placement.matchingCount();
        int count = result.placementCount(matchingCount);
        int prize = placement.prizeMoney();

        System.out.printf("%d개 일치 (%d원)- %d개%n", matchingCount, prize, count);
    }
}
