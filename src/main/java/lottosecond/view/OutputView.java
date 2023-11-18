package lottosecond.view;


import lottosecond.domain.Winner;
import lottosecond.domain.WinnerBoard;
import lottosecond.domain.lotto.Lotto;
import lottosecond.domain.lotto.Lottos;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class OutputView {

    public void printLottoListInfo(Lottos lottos) {
        totalLottoCount(lottos.getLottoCount());

        StringBuilder stringBuilder = new StringBuilder();
        for (Lotto lotto : lottos.getLottoList()) {
            stringBuilder.append(lotto)
                    .append("\n");
        }
        lottoList(stringBuilder.toString());
    }

    public void printWinnerStatistics(WinnerBoard winnerBoard) {
        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("---------");

        Map<Winner, Long> winnerMap = makeWinnerMap(winnerBoard);

        StringBuilder stringBuilder = new StringBuilder();

        for (Winner winner : winnerMap.keySet()) {
            stringBuilder.append(winner.getNormalNumberMatchCount() + "개 일치");
            if (winner == Winner.SECOND) {
                stringBuilder.append(", 보너스 볼 일치");
            }
            stringBuilder.append(" (" + winner.getPrice() + "원)- ")
                    .append(winnerMap.get(winner) + "개\n");
        }
        String winnerStatic = stringBuilder.toString();
        System.out.println(winnerStatic);
    }

    public void printEarningRate(double earningRate) {
        StringBuilder stringBuilder = new StringBuilder();
        String output = stringBuilder.append("총 수익률은 " + earningRate + "입니다.")
                .append("(기준이 1이기 때문에 결과적으로 ")
                .append(earningRate >= 1 ? "이득이" : "손해")
                .append("라는 의미임)")
                .toString();
        System.out.println(output);
    }

    private Map<Winner, Long> makeWinnerMap(WinnerBoard winnerBoard) {
        Map<Winner, Long> winnerMap = new LinkedHashMap<>();
        fillCollectMap(winnerMap);

        List<Winner> winners = winnerBoard.getWinners();
        Map<Winner, Long> collect = winners.stream().collect(Collectors.groupingBy(
                winner -> winner,
                Collectors.counting()
        ));

        for (Winner winner : collect.keySet()) {
            winnerMap.put(winner, collect.get(winner));
        }
        return winnerMap;
    }

    private void fillCollectMap(Map<Winner, Long> collect) {
        collect.putIfAbsent(Winner.FIFTH, 0L);
        collect.putIfAbsent(Winner.FOURTH, 0L);
        collect.putIfAbsent(Winner.THIRD, 0L);
        collect.putIfAbsent(Winner.SECOND, 0L);
        collect.putIfAbsent(Winner.FIRST, 0L);
    }



    private void totalLottoCount(int lottoCount) {
        System.out.println(lottoCount + "개를 구매했습니다.");
    }

    private void lottoList(Object object) {
        System.out.println(object);
    }
}
