package lotto.view;

import lotto.model.Lotto;
import lotto.model.Rank;
import lotto.model.Statistics;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class ResultView {

    public static void printBoughtHistory(List<Lotto> manualLottos, List<Lotto> autoLottos) {
        System.out.println("수동으로 " + manualLottos.size() + "장, 자동으로 " + autoLottos.size() + "개를 구매했습니다.");

        Stream.concat(manualLottos.stream(), autoLottos.stream())
            .forEach(lotto -> System.out.println(lotto.toString()));
    }

    public static void printCountOfRank(Statistics statistics) {
        System.out.println("당첨 통계");
        System.out.println("---------");

        Map<Rank, Integer> countOfRank = statistics.getCountOfRank();
        countOfRank.keySet().stream()
            .sorted(Comparator.reverseOrder())
            .filter(rank -> rank.getCountOfMatch() != 0)
            .map(rank -> convertToMatchMessage(rank, countOfRank.get(rank)))
            .forEach(System.out::println);
    }

    public static void printReturnsOfInvestment(Statistics statistics) {
        double returnsOfInvestment = statistics.getReturnsOfInvestment();
        System.out.print("총 수익률은 " + returnsOfInvestment + "입니다.");

        if (returnsOfInvestment < 1) {
            System.out.println("(기준이 1이기 때문에 결과적으로 손해라는 의미임)");
        }
    }

    private static String convertToMatchMessage(Rank rank, int countOfLotto) {
        if (rank == Rank.SECOND) {
            return rank.getCountOfMatch() + "개 일치, 보너스 볼 일치(" + rank.getWinningMoney() + "원)- " + countOfLotto + "개";
        }

        return rank.getCountOfMatch() + "개 일치 (" + rank.getWinningMoney() + "원)- " + countOfLotto + "개";
    }
}
