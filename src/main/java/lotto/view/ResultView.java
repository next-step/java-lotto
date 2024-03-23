package lotto.view;

import lotto.domain.LottoRank;
import lotto.domain.Lottos;

import java.util.HashMap;

public class ResultView {

    public static void printLottoCount(int count) {
        System.out.println(count + "개를 구매했습니다.");
    }

    public static void printLottos(Lottos lottos) {
        lottos.getLottos().forEach(lotto -> System.out.println(lotto.getLottoNumbers().toString()));
    }

    public static void printWinningStatistics(HashMap<LottoRank, Integer> winningStatistics) {
        System.out.println("당첨 통계");
        System.out.println("---------");

        checkWinningStatistics(winningStatistics);

        winningStatistics.entrySet()
                .forEach(l -> System.out.println(l.getKey().getResultString() + l.getValue() + "개"));
    }

    private static void checkWinningStatistics(HashMap<LottoRank, Integer> winningStatistics) {
        if (winningStatistics.isEmpty()) {
            System.out.println("로또번호와 일치하는 게 없습니다");
        }
    }

    public static void printRateOfReturn(double winningRate) {
        System.out.println("총 수익률은 " + winningRate + "입니다.");
    }

}
