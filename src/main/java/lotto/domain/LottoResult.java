package lotto.domain;

import java.util.Arrays;

public enum LottoResult {
    NO_REWARD(0, false, 0, "상금이 없습니다."),
    THREE_MATCHING(3, false, 5_000, "3개 일치 (5,000원) - "),
    FOUR_MATCHING(4, false, 50_000, "4개 일치 (50,000원) - "),
    FIVE_MATCHING(5, false, 1_500_000, "5개 일치 (1,500,000원) - "),
    FIVE_MATCHING_BONUS(5, true, 30_000_000, "5개 일치, 보너스 볼 일치 (30,000,000) - "),
    SIX_MATCHING(6, false, 2_000_000_000, "6개 일치 (2,000,000,000원) - ");

    private final int matchCount;
    private final boolean includeBonus;
    private final int reward;
    private final String description;

    LottoResult(int count, boolean includeBonus, int reward, String description) {
        this.matchCount = count;
        this.includeBonus = includeBonus;
        this.reward = reward;
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public int getReward() {
        return reward;
    }

    public static LottoResult from(int count) {
        if (count < 3) {
            return LottoResult.NO_REWARD;
        }
        return from(count, false);
    }

    public static LottoResult from(int count, boolean includeBonus) {
        return Arrays.stream(LottoResult.values())
            .filter(lottoResult -> isSameCountAndBonus(lottoResult, count, includeBonus))
            .findAny()
            .orElseThrow(() -> new IllegalArgumentException("[ERROR] 당첨 결과를 찾지 못했습니다."));
    }

    private static boolean isSameCountAndBonus(LottoResult lottoResult, int count, boolean includeBonus) {
        return lottoResult.matchCount == count && lottoResult.includeBonus == includeBonus;
    }
}
