package lottoauto.view;

import lottoauto.domain.aggregate.Aggregator;
import lottoauto.domain.aggregate.WinnerBoard;

import java.util.Map;

public class OutputView {

    public void printLottoListInfo(Aggregator aggregator) {
        totalLottoCount(aggregator.totalLottoCount());
        lottoList(aggregator.lottoListInfo());
    }

    public void printWinnerStatistics(WinnerBoard winnerBoard) {
        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("---------");

        Map<Integer, Integer> priceBoard = winnerBoard.getPriceBoard();

        StringBuilder stringBuilder = new StringBuilder();
        for (int matchCount=3; matchCount<=6; matchCount++) {
            stringBuilder.append(matchCount + "개 일치 " + "(" + priceBoard.get(matchCount) + "원)- ")
                    .append(winnerBoard.get(matchCount) + "개\n");
        }
        String winnerStatic = stringBuilder.toString();
        System.out.println(winnerStatic);

    }

    public void printEarningRate(double earningRate) {
        StringBuilder stringBuilder = new StringBuilder();
        String output = stringBuilder.append("총 수익률은 " + earningRate + "입니다.")
                .append("(기준이 1이기 때문에 결과적으로 ")
                .append(earningRate >= 1 ? "이득이" : "손헤")
                .append("라는 의미임)")
                .toString();
        System.out.println(output);
    }

    private void totalLottoCount(int lottoCount) {
        System.out.println(lottoCount + "개를 구매했습니다.");
    }

    private void lottoList(Object object) {
        System.out.println(object);
    }
}
