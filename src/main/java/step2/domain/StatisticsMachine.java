package step2.domain;

import static java.math.RoundingMode.HALF_UP;
import static step2.constant.Prize.ALL;
import static step2.constant.Prize.FIVE;
import static step2.constant.Prize.FOUR;
import static step2.constant.Prize.THREE;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import step2.constant.Prize;

public class StatisticsMachine {

    private final Map<String, Integer> map;

    public StatisticsMachine() {
        map = new HashMap<>();
        for (Prize p : Prize.values()) {
            map.put(p.name(), 0);
        }
    }

    public Map<String, Integer> sortPrize(List<Prize> pirzeList) {
        for (Prize p : pirzeList) {
            count(p.name());
        }

        return map;
    }

    private void count(String name) {
        if (THREE.name().equals(name)) {
            int cnt = map.get(name);
            map.replace(name, cnt + 1);
        }

        if (FOUR.name().equals(name)) {
            int cnt = map.get(name);
            map.replace(name, cnt + 1);
        }

        if (FIVE.name().equals(name)) {
            int cnt = map.get(name);
            map.replace(name, cnt + 1);
        }

        if (ALL.name().equals(name)) {
            int cnt = map.get(name);
            map.replace(name, cnt + 1);
        }
    }

    public long getRewards(Map<String, Integer> sortedPrize) {
        long sum = 0L;
        for (Entry<String, Integer> p : sortedPrize.entrySet()) {
            if (THREE.name().equals(p.getKey())) {
                sum += THREE.getReward() * p.getValue();
            }

            if (FOUR.name().equals(p.getKey())) {
                sum += FOUR.getReward() * p.getValue();
            }

            if (FIVE.name().equals(p.getKey())) {
                sum += FIVE.getReward() * p.getValue();
            }

            if (ALL.name().equals(p.getKey())) {
                sum += ALL.getReward() * p.getValue();
            }
        }

        return sum;
    }

    public BigDecimal getRoi(int invest, long rewards) {
        return new BigDecimal(rewards).divide(new BigDecimal(invest), HALF_UP)
                                      .setScale(2, HALF_UP);
    }
}
