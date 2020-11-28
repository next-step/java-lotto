package lottery.domain;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class LotteryResult {
    Map<Integer, Integer> lotteryResultMap;

    public LotteryResult() {
        lotteryResultMap = new HashMap<>();
    }

    public LotteryResult(int key, int value) {
        this();
        this.lotteryResultMap.put(key, value);
    }

    public void update(int key, int value) {
        if (this.lotteryResultMap.containsKey(key)) {
            this.lotteryResultMap.replace(key, lotteryResultMap.get(key) + value);
        }
        if (!this.lotteryResultMap.containsKey(key)) {
            this.lotteryResultMap.put(key, value);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LotteryResult that = (LotteryResult) o;
        return Objects.equals(lotteryResultMap, that.lotteryResultMap);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lotteryResultMap);
    }
}
