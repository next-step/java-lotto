package lotto.io;

import lotto.model.Lotteries;
import lotto.model.Rank;

import java.text.MessageFormat;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Function;
import java.util.stream.Collectors;

public class OutputView {

    public static void viewLotto(Lotteries lotteries) {
        lotteries.getLotteries()
                .forEach(lottery -> System.out.println(lottery.getNumbers()
                        .stream()
                        .map(e -> String.valueOf(e.getValue()))
                        .collect(Collectors.joining(","))));
    }

    public static void viewResult(List<Rank> ranks) {

        Map<Rank, Long> map = ranks.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        System.out.println("당첨 통계");
        System.out.println("--------");
        map.forEach(PRINT_WINNING_RANK);
    }

    private static final BiConsumer<Rank, Long> PRINT_WINNING_RANK =
            (rank, count) -> System.out.println(MessageFormat.format("{0}개 일치 ({1})-{2}개", rank.getCountOfMatch(), rank.getWinningMoney(), count));

    public static void viewEarningRate(int money, List<Rank> ranks) {

        Map<Rank, Long> resultMap = ranks.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        System.out.println(MessageFormat.format("총 수익률은{0}입니다", getEarning(resultMap) / money));
    }

    private static int getEarning(Map<Rank, Long> resultMap) {
        int earning = 0;

        for (Map.Entry<Rank, Long> entry : resultMap.entrySet()) {
            Rank rank = entry.getKey();
            Long count = entry.getValue();
            earning += rank.getWinningMoney() * count;
        }
        return earning;
    }
}
