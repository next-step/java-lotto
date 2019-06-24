package lotto;

import java.util.Arrays;

public enum LottoEnum {

    Winner3(3, 5000),
    Winner4(4, 50000),
    Winner5(5, 1500000),
    Winner6(6, 20000000),
    EMPTY(0, 0);

    private int winnerCount;
    private int price;

    LottoEnum(int winnerCount, int price) {
        this.winnerCount = winnerCount;
        this.price = price;
    }

    public static LottoEnum findByPrice(int winnerCount) {
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

}
