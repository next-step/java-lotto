package step3.domian;

public enum Prize {
    THREE_PRIZE(5_000),
    FOUR_PRIZE(50_000),
    FIVE_PRIZE(1_500_000),
    FIVE_BONUS_PRIZE(30_000_000),
    SIX_PRIZE(2_000_000_000);

    final int prizeMoney;


    Prize(int prizeMoney) {
        this.prizeMoney = prizeMoney;
    }

    public static Prize getPrize(int count, Lotto lotto, int bonus) {
        switch (count) {
            case 3:
                return THREE_PRIZE;
            case 4:
                return FOUR_PRIZE;
            case 5:
                return isContainBonus(lotto, bonus);
            case 6:
                return SIX_PRIZE;
            case 7:
                return FIVE_BONUS_PRIZE;
            default:
                return null;
        }
    }

    private static Prize isContainBonus(Lotto lotto, int bonus) {
        if (lotto.isContain(bonus) == 1) {
            return FIVE_BONUS_PRIZE;
        }
        return FIVE_PRIZE;
    }
}
