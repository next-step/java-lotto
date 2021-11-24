package lotto.domain;

import java.util.Arrays;

public enum Prize {
    SEVENTH(0, 0),
    SIXTH(1, 0),
    FIFTH(2, 0),
    FOURTH(3, 5_000),
    THIRD(4, 50_000),
    SECOND(5, 1_500_000),
    BONUS_SECOND(5, 30_000_000),
    FIRST(6, 2_000_000_000);

    private final int matching;

    private final int prize;

    Prize(Integer matching, Integer prize) {
        this.matching = matching;
        this.prize = prize;
    }

    public static Prize findPrize(Lotto lotto, WinningNumbers winningNumbers, BonusBall bonus) {
        Prize prize = Arrays.asList(values()).stream()
                .filter(prizeEnum -> prizeEnum.matching == lotto.checkMatching(winningNumbers))
                .findAny().get();
        if (prize.matching == 5 && checkBonus(lotto, bonus)) {
            return Prize.BONUS_SECOND;
        }
        if (prize.matching == 5 && !checkBonus(lotto, bonus)) {
            return Prize.SECOND;
        }
        return prize;
    }

    public static Boolean checkBonus(Lotto lotto, BonusBall bonus) {
        return lotto.checkContainNumber(bonus);
    }

    public int getPrize() {
        return prize;
    }

    public int getMatching() {
        return matching;
    }
}
