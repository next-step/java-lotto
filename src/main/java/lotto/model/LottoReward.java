package lotto.model;

import static lotto.LottoMatchResult.of;

import java.util.Arrays;
import java.util.Objects;

import lotto.LottoMatchResult;

public enum LottoReward {
    firstPlace(of(6), 2000000000),
    secondPlace(of(5), 1500000),
    thirdPlace(of(4), 50000),
    fourthPlace(of(3), 5000),
    ;

    private final LottoMatchResult matchResult;
    private final int rewardAmount;

    LottoReward(LottoMatchResult matchResult, int rewardAmount) {
        this.matchResult = matchResult;
        this.rewardAmount = rewardAmount;
    }

    public static LottoReward findByMatchResult(LottoMatchResult lottoMatchResult) {
        return Arrays.stream(values())
                     .filter(lottoReward -> Objects.equals(lottoReward.matchResult, lottoMatchResult))
                     .findFirst()
                     .orElseThrow(() -> new IllegalArgumentException("상금이 정의되지 않았습니다"));
    }

    public int getRewardAmount() {
        return rewardAmount;
    }
}
