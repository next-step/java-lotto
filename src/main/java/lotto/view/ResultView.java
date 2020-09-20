package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.Rank;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ResultView {

    public static void printLottoCount(int lottoCount) {
        System.out.println(lottoCount + "개를 구매했습니다.");
    }

    public static void printLotto(List<Lotto> buyLotto) {
        for(Lotto lotto : buyLotto) {
            System.out.println("[" + String.join(",", lotto.getLottoNumber()) + "]");
        }
    }

    public static void printWinningStatistics(Map<Rank, Integer> rank) {
        System.out.println("당첨통계");
        System.out.println("---------");
        rank.keySet()
                .stream()
                .filter(rank1 -> rank1.getMatchCount() != 0)
                .collect(Collectors.toList())
                .stream()
                .forEach(rank1 -> {
                    System.out.print(rank1.getMatchCount() + "개 일치 (" + rank1.getPrize() + ") - ");
                    System.out.println(rank.get(Rank.valueOf(rank1.name())) + "개");
                });
    }

    public static void printTotalYield(BigDecimal totalYield) {
        System.out.println("총 수익률은 " + totalYield + "입니다.");
    }
}
