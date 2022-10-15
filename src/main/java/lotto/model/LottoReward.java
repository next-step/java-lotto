package lotto.model;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

import lotto.LottoMatchResult;

public enum LottoReward {
    FIRST_PLACE(6, 2000000000),
    SECOND_PLACE(5, 1500000),
    THIRD_PLACE(4, 50000),
    FOURTH_PLACE(3, 5000),
    ;

    private final int matchCount;
    private final int rewardAmount;

    LottoReward(int matchResult, int rewardAmount) {
        this.matchCount = matchResult;
        this.rewardAmount = rewardAmount;
    }

    public LottoMatchResult getLottoMatchResult() {
        return LottoMatchResult.of(this.matchCount);
    }

    public static Optional<LottoReward> findByMatchResult(LottoMatchResult lottoMatchResult) {
        return Arrays.stream(values())
                     .filter(lottoReward -> Objects.equals(lottoReward.getLottoMatchResult(), lottoMatchResult))
                     .findFirst();
    }

    public int getRewardAmount() {
        return rewardAmount;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public static List<LottoReward> getValuesOrderByMatchResult() {
        return Arrays.stream(values()).sorted(Comparator.comparing(LottoReward::getMatchCount)).collect(Collectors.toList());
    }
}
