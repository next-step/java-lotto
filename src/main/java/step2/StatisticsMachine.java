package step2;

import static step2.constant.Prize.ALL;
import static step2.constant.Prize.FIVE;
import static step2.constant.Prize.FOUR;
import static step2.constant.Prize.THREE;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import step2.constant.Prize;

public class StatisticsMachine {

    // organize prize - return money
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
}
