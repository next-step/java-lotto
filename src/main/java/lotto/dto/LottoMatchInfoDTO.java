package lotto.dto;

import java.util.Objects;

public class LottoMatchInfoDTO {
    private final int matchCount;
    private final int lottoNum;
    private final int reward;

    private LottoMatchInfoDTO(int matchCount, int lottoNum, int reward) {
        this.matchCount = matchCount;
        this.lottoNum = lottoNum;
        this.reward = reward;
    }

    public static LottoMatchInfoDTO valueOf(int matchCount, int lottoNum, int reward) {
        return new LottoMatchInfoDTO(matchCount, lottoNum, reward);
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getLottoNum() {
        return lottoNum;
    }

    public int getReward() {
        return reward;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoMatchInfoDTO that = (LottoMatchInfoDTO) o;
        return getMatchCount() == that.getMatchCount() && getLottoNum() == that.getLottoNum() && getReward() == that.getReward();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getMatchCount(), getLottoNum(), getReward());
    }
}
