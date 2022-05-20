package lotto.domain;

import java.util.Arrays;
import java.util.Optional;

public enum WinningsType {
    사등(3, 5_000),
    삼등(4, 50_000),
    이등(5, 1_500_000),
    일등(6, 2_000_000_000);

    private int numberOfSame;
    private int winnings;

    WinningsType(int numberOfSame, int winnings) {
        this.numberOfSame = numberOfSame;
        this.winnings = winnings;
    }

    public int getNumberOfSame() {
        return numberOfSame;
    }

    public int getWinnings() {
        return winnings;
    }

    public static Optional<WinningsType> selectWinningsType(int numberOfSame) {
        return Arrays.stream(WinningsType.values()).filter(type -> type.isSameNumber(numberOfSame))
                .findAny();
    }

    private boolean isSameNumber(int numberOfSame) {
        return this.numberOfSame == numberOfSame;
    }
}
