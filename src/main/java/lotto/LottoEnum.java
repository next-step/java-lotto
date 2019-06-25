package lotto;

import java.util.Arrays;

public enum LottoEnum {

    Winner5(3, 5000),
    Winner4(4, 50000),
    Winner3(5, 1500000),
    Winner2(5, 30000000),
    Winner1(6, 200000000),
    EMPTY(0, 0);

    private int winnerCount;
    private int price;

    LottoEnum(int winnerCount, int price) {
        this.winnerCount = winnerCount;
        this.price = price;
    }

    public static LottoEnum findByPrice(int winnerCount, boolean matchBonus) {
        if (isBonusWinner(winnerCount, matchBonus)) {
            return LottoEnum.Winner2;
        }
        return Arrays.stream(LottoEnum.values())
                .filter(itemArray -> itemArray.hasDataGroup(winnerCount))
                .findAny()
                .orElse(EMPTY);
    }

    public boolean hasDataGroup(int winnerCount) {
        return this.winnerCount == winnerCount;
    }

    public int price() {
        return price;
    }

    private static boolean isBonusWinner(int winnerCount, boolean matchBonus) {
        return winnerCount == 5 && matchBonus;
    }

}
