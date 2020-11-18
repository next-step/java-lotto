package step02.domain;

import java.util.Objects;

public class LottoReward {
    private final int number;
    private final int reward;
    private final int count;

    private LottoReward(int number, int reward, int count) {
        this.number = number;
        this.reward = reward;
        this.count = count;
    }

    public static LottoReward of(int number, int reward, int count) {
        return new LottoReward(number, reward, count);
    }

    public LottoReward updateCount(int count) {
        return of(number, reward, count);
    }

    public int getNumber() {
        return number;
    }

    public int calcaulte() {
        return reward * count;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoReward that = (LottoReward) o;
        return number == that.number &&
                reward == that.reward &&
                count == that.count;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number, reward, count);
    }

}
