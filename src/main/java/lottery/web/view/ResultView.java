package lottery.web.view;

import lottery.domain.LotteryRank;
import lottery.domain.LotteryWinningStatistics;

import java.util.*;
import java.util.stream.Collectors;

public class ResultView {

    public static void viewStatistics(Map<String, Object> model, LotteryWinningStatistics statistics) {
        model.put("ranks", convertToValue(statistics));
        model.put("revenueRate", (int) (statistics.revenueRate().rate * 100));
    }

    private static List<Map<String, Object>> convertToValue(LotteryWinningStatistics statistics) {
        return Arrays.stream(LotteryRank.values())
                .filter(rank -> rank != LotteryRank.NONE)
                .sorted(Comparator.reverseOrder())
                .map(rank -> convertRank(statistics, rank))
                .collect(Collectors.toList());
    }

    private static Map<String, Object> convertRank(LotteryWinningStatistics statistics, LotteryRank rank) {
        Map<String, Object> map = new HashMap<>();
        map.put("matchCount", rank.matchCount);
        map.put("matchBonus", rank == LotteryRank.SECOND ? ", 보너스 볼 일치" : " ");
        map.put("winningMoney", rank.winningMoney.amount);
        map.put("winningCount", statistics.countRank(rank).amount);
        return map;
    }
}
