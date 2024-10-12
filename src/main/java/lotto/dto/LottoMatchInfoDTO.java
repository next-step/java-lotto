package lotto.dto;

import java.util.Objects;

public class LottoMatchInfoDTO {
    private final int matchCount;
    private final int id;
    private final int reward;

    private LottoMatchInfoDTO(int matchCount, int id, int reward) {
        this.matchCount = matchCount;
        this.id = id;
        this.reward = reward;
    }

    public static LottoMatchInfoDTO valueOf(int matchCount, int id, int reward) {
        return new LottoMatchInfoDTO(matchCount, id, reward);
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getId() {
        return id;
    }

    public int getReward() {
        return reward;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoMatchInfoDTO that = (LottoMatchInfoDTO) o;
        return getMatchCount() == that.getMatchCount() && getId() == that.getId() && getReward() == that.getReward();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getMatchCount(), getId(), getReward());
    }
}
