package lotto.domain;

import java.util.Arrays;

public enum Rank {
    꽝(0, 0),
    오등(3, 5_000),
    사등(4, 50_000),
    삼등(5, 1_500_000),
    이등(5, 30_000_000),
    일등(6, 2_000_000_000);

    public static final int FIVE = 5;
    public static final int NUMBER_MINIMUM = 0;
    public static final int NUMBER_MAXIMUM = 6;

    private int numberOfSame;
    private int winnings;

    Rank(int numberOfSame, int winnings) {
        this.numberOfSame = numberOfSame;
        this.winnings = winnings;
    }

    public int getNumberOfSame() {
        return numberOfSame;
    }

    public int getWinnings() {
        return winnings;
    }

    public static Rank selectType(int numberOfSame, boolean isSameBonusNumber) {
        validateNumber(numberOfSame);

        if (numberOfSame == FIVE) {
            return whenCountIsFive(isSameBonusNumber);
        }

        return Arrays.stream(Rank.values()).filter(type -> type.isSameNumber(numberOfSame))
                .findAny().orElse(꽝);
    }

    private static void validateNumber(int numberOfSame) {
        if (numberOfSame < NUMBER_MINIMUM || numberOfSame > NUMBER_MAXIMUM) {
            throw new IllegalArgumentException("랭크에 사용될 숫자가 유효하지 않습니다.");
        }
    }

    private boolean isSameNumber(int numberOfSame) {
        return this.numberOfSame == numberOfSame;
    }

    private static Rank whenCountIsFive(boolean isSameBonusNumber) {
        if (isSameBonusNumber) {
            return 이등;
        }
        return 삼등;
    }
}
