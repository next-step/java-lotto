package step3.util;

import static java.math.RoundingMode.DOWN;
import static step3.constant.Prize.FIFTH;
import static step3.constant.Prize.FIRST;
import static step3.constant.Prize.FOURTH;
import static step3.constant.Prize.SECOND;
import static step3.constant.Prize.THIRD;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import step3.constant.Prize;

public class StatisticsUtil {

    private static Map<String, Integer> map =  new HashMap<>();

    private static void init() {
        for (Prize p : Prize.values()) {
            map.put(p.name(), 0);
        }
    }

    public static Map<String, Integer> summarize(List<Prize> pirzeList) {
        init();
        for (Prize p : pirzeList) {
            count(p.name());
        }

        return map;
    }

    private static void count(String name) {
        map.forEach((prize, count) -> {
            if (prize.equals(name)) {
                map.replace(name, count + 1);
            }
       });
    }

    public static long getRewards(Map<String, Integer> summarize) {
        long sum = 0L;
        for (Entry<String, Integer> prize : summarize.entrySet()) {
            sum = getSum(prize, sum);
        }

        return sum;
    }

    private static long getSum(Entry<String, Integer> p, long sum) {
        if (FIRST.name().equals(p.getKey())) {
            sum += FIRST.getReward() * p.getValue();
        }

        if (SECOND.name().equals(p.getKey())) {
            sum += SECOND.getReward() * p.getValue();
        }

        if (THIRD.name().equals(p.getKey())) {
            sum += THIRD.getReward() * p.getValue();
        }

        if (FOURTH.name().equals(p.getKey())) {
            sum += FOURTH.getReward() * p.getValue();
        }

        if (FIFTH.name().equals(p.getKey())) {
            sum += FIFTH.getReward() * p.getValue();
        }

        return sum;
    }

    public static BigDecimal getRoi(int invest, long rewards) {
        return new BigDecimal(rewards).divide(new BigDecimal(invest), 2, DOWN);
    }
}
