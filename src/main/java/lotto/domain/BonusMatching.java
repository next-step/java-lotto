package lotto.domain;

import java.util.Arrays;

public enum BonusMatching {
    TRUE(true),
    FALSE(false);

    private final boolean isBonusMatching;

    BonusMatching(boolean isBonusMatching) {
        this.isBonusMatching = isBonusMatching;
    }

    public static BonusMatching from(boolean bonus) {
        return Arrays.stream(values())
                .filter(bonusMatching -> bonusMatching.isBonusMatching == bonus)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("유효하지 않은 보너스 번호 조회입니다."));
    }
}
