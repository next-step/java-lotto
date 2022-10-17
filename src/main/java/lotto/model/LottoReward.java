package lotto.model;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

public enum LottoReward {
    FIRST_PLACE(6, null, 2000000000),
    SECOND_PLACE(5, true, 30000000),
    THIRD_PLACE(5, false, 1500000),
    FOURTH_PLACE(4, null, 50000),
    FIFTH_PLACE(3, null, 5000),
    ;

    private final int matchCount;
    private final Optional<Boolean> maybeBonusNumberMatched;
    private final int rewardAmount;

    LottoReward(int matchResult, Boolean maybeBonusNumberMatched, int rewardAmount) {
        this.matchCount = matchResult;
        this.maybeBonusNumberMatched = Optional.ofNullable(maybeBonusNumberMatched);
        this.rewardAmount = rewardAmount;
    }

    public static Optional<LottoReward> findByMatchResult(int count, boolean bonusNumberMatched) {
        return Arrays.stream(values())
                     .filter(lottoReward -> lottoReward.matched(count, bonusNumberMatched))
                     .findFirst();
    }

    public boolean matched(int count, boolean bonusNumberMatched) {
        if (this.maybeBonusNumberMatched.isPresent()) {
            return Objects.equals(this.matchCount, count) && Objects.equals(this.maybeBonusNumberMatched.get(), bonusNumberMatched);
        }

        return Objects.equals(this.matchCount, count);
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
