package lotto.io;

import lotto.model.Lotteries;
import lotto.model.Rank;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class OutputView {

    public static void viewLotto(Lotteries lotteries) {
        lotteries.getLotteries()
                .forEach(lottery -> System.out.println(lottery.getNumbers()
                        .stream()
                        .map(e -> String.valueOf(e.getNumber()))
                        .collect(Collectors.joining(","))));
    }

    public static void viewResult(List<Rank> ranks) {

        Map<Rank, Long> map = ranks.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        System.out.println("당첨 통계");
        System.out.println("--------");
        map.forEach((rank, count) -> System.out.println(rank.getCountOfMatch() + "개 일치 (" + rank.getWinningMoney() + ")-" + count + "개"));
    }

    public static void viewEarningRate(int money, List<Rank> ranks) {

        int earning = 0;
        Map<Rank, Long> map = ranks.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        for (Map.Entry<Rank, Long> entry : map.entrySet()) {
            Rank rank = entry.getKey();
            Long count = entry.getValue();
            earning += rank.getWinningMoney() * count;
        }

        System.out.println("Earing is .. :" + earning);
        System.out.println("총 수익률은" + (double) (earning / money) + "입니다");
    }
}
