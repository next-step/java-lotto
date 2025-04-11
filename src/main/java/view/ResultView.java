package view;

import model.*;

public class ResultView {
    public void printLottos(Lottos lottos) {
        System.out.printf("%d개를 구매했습니다\n", lottos.count());
        for (int i = 0; i < lottos.count(); i++) {
            System.out.println(lottos.get(i).numbers());
        }
    }

    public void printResult(LottoResult result, Placements placements) {
        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("---------");

        printPlacementStat(result, placements.placementAt(3));
        printPlacementStat(result, placements.placementAt(2));
        printPlacementStat(result, placements.placementAt(1));
        printPlacementStat(result, placements.placementAt(0));

        double yield = result.yield(placements);
        printYield(yield);
        System.out.println();
    }

    public void printPlacementStat(LottoResult result, Placement placement) {
        int matchingCount = placement.matchingCount();
        int count = result.placementCount(matchingCount);
        int prize = placement.prize();
        System.out.printf("%d개 일치 (%d원)- %d개%n", matchingCount, prize, count);
    }

    private void printYield(double yield) {
        String verdict = "본전";

        if (yield > 1) {
            verdict = "이득";
        }
        if (yield < 1) {
            verdict = "손해";
        }

        System.out.printf("총 수익률은 %.0f입니다.(기준이 1이기 때문에 결과적으로 %s라는 의미임)", yield, verdict);
    }
}
