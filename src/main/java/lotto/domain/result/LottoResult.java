package lotto.domain.result;

import java.util.Arrays;

public enum LottoResult {
    NO_REWARD(0, false, 0, "상금이 없습니다."),
    THREE_MATCHING(3, false, 5_000, "3개 일치 (5,000원) - "),
    FOUR_MATCHING(4, false, 50_000, "4개 일치 (50,000원) - "),
    FIVE_MATCHING(5, false, 1_500_000, "5개 일치 (1,500,000원) - "),
    FIVE_MATCHING_BONUS(5, true, 30_000_000, "5개 일치, 보너스 볼 일치 (30,000,000) - "),
    SIX_MATCHING(6, false, 2_000_000_000, "6개 일치 (2,000,000,000원) - ");

    private static final int MINIMUM_NUMBER_OF_MATCHING = 3;
    private static final int COUNT_TO_CHECK_BONUS = 5;

    private final int count;
    private final boolean includeBonus;
    private final int reward;
    private final String description;

    LottoResult(int count, boolean includeBonus, int reward, String description) {
        this.count = count;
        this.includeBonus = includeBonus;
        this.reward = reward;
        this.description = description;
    }

    public static LottoResult of(int count, boolean hasBonus) {
        if (count < MINIMUM_NUMBER_OF_MATCHING) {
            return LottoResult.NO_REWARD;
        }

        return Arrays.stream(LottoResult.values())
            .filter(lottoResult -> isSameCountAndBonus(lottoResult, count, hasBonus))
            .findAny()
            .orElseThrow(() -> new IllegalArgumentException("[ERROR] 당첨 결과를 찾지 못했습니다."));
    }

    private static boolean isSameCountAndBonus(LottoResult lottoResult, int count, boolean includeBonus) {
        if (notCheckBonus(count)) {
            return lottoResult.count == count;
        }
        return lottoResult.count == count && lottoResult.includeBonus == includeBonus;
    }

    private static boolean notCheckBonus(int count) {
        return count != COUNT_TO_CHECK_BONUS;
    }

    public String getDescription() {
        return description;
    }

    public int getReward() {
        return reward;
    }
}
