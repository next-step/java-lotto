package lottoauto;

import java.util.Arrays;

public enum LottoRule {
    MISS(new HitCount(0),false,  new Money(0)),
    THREE_HIT(new HitCount(3),false,  new Money(5_000)),
    FOUR_HIT(new HitCount(4), false, new Money(50_000)),
    FIVE_HIT(new HitCount(5), false, new Money(1_500_000)),
    FIVE_HIT_WITH_BONUS(new HitCount(5), true, new Money(30_000_000)),
    SIX_HIT(new HitCount(6), false, new Money(2_000_000_000));

    private HitCount hitCount;
    private boolean isMatchedBonus;
    private Money winningMoney;

    LottoRule(HitCount hitCount, boolean isMatchedBonus, Money winningMoney) {
        this.hitCount = hitCount;
        this.isMatchedBonus = isMatchedBonus;
        this.winningMoney = winningMoney;
    }

    private HitCount hitCount() {
        return hitCount;
    }

    private boolean isMatchedBonus() {
        return isMatchedBonus;
    }

    private Money winningMoney() {
        return winningMoney;
    }

    public static LottoRule valueOf(final HitCount hitCount, final boolean isMatchedBonus) {
        LottoRule[] lottoRules = values();

        return Arrays.stream(lottoRules)
                .filter(lottoRule -> lottoRule.hitCount().equals(hitCount) && lottoRule.isMatchedBonus() == isMatchedBonus)
                .findFirst()
                .orElse(MISS);
    }

    public boolean isEqualsHitCount(HitCount hitCount) {
        return this.hitCount.equals(hitCount);
    }

    @Override
    public String toString() {
        return hitCount.toString() + "개" + "일치 (" + winningMoney.toString() + ")-";
    }

    public int calcProceed(int count) {
        return winningMoney.calcProceed(count);
    }
}
