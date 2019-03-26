package lottery.web.view;

import lottery.domain.LotteryRank;
import lottery.domain.LotteryWinningStatistics;

import java.util.*;
import java.util.stream.Collectors;

public class ResultView {

    public static void viewStatistics(Map<String, Object> model, LotteryWinningStatistics statistics) {
        model.put("ranks", convertToRankMaps(statistics));
        model.put("revenueRate", statistics.revenueRate().percentage());
    }

    private static List<Map<String, Object>> convertToRankMaps(LotteryWinningStatistics statistics) {
        return Arrays.stream(LotteryRank.values())
                .filter(rank -> rank != LotteryRank.NONE)
                .sorted(Comparator.reverseOrder())
                .map(rank -> convertToRankMap(statistics, rank))
                .collect(Collectors.toList());
    }

    private static Map<String, Object> convertToRankMap(LotteryWinningStatistics statistics, LotteryRank rank) {
        Map<String, Object> map = new HashMap<>();
        map.put("matchCount", rank.matchCount);
        map.put("matchBonus", rank == LotteryRank.SECOND ? ", 보너스 볼 일치" : " ");
        map.put("winningMoney", rank.winningMoney.amount);
        map.put("winningCount", statistics.countRank(rank).amount);
        return map;
    }
}
