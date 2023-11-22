package step3.util;

import static java.math.RoundingMode.DOWN;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import step3.constant.Prize;

public class StatisticsUtil {

    private static Map<Prize, Integer> map =  new HashMap<>();

    private static void init() {
        for (Prize p : Prize.values()) {
            map.put(p, 0);
        }
    }

    public static Map<Prize, Integer> summarize(List<Prize> pirzeList) {
        init();
        for (Prize p : pirzeList) {
            count(p.name());
        }

        return getWinnings(map);
    }

    private static void count(String name) {
        map.forEach((prize, count) -> {
            if (prize.name().equals(name)) {
                map.replace(prize, count + 1);
            }
       });
    }

    private static Map<Prize, Integer> getWinnings(Map<Prize, Integer> map) {
        map.entrySet().removeIf(entry -> entry.getKey() == Prize.BAD_LUCK);
        return map;
    }

    public static long getRewards(Map<Prize, Integer> summarize) {
        long sum = 0L;
        for (Entry<Prize, Integer> prize : summarize.entrySet()) {
            sum = prize.getKey().getReward() * prize.getValue();
        }

        return sum;
    }

    public static BigDecimal getRoi(int invest, long rewards) {
        return new BigDecimal(rewards).divide(new BigDecimal(invest), 2, DOWN);
    }
}
