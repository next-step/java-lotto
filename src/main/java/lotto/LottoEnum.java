package lotto;

import java.util.Arrays;

public enum LottoEnum {

    Winner3("3개 일치 ", 5000),
    Winner4("4개 일치 ", 50000),
    Winner5("5개 일치 ", 1500000),
    Winner6("6개 일치 ", 20000000),
    EMPTY("", 0);

    private String winnerCount;
    private int price;

    LottoEnum(String winnerCount, int price) {
        this.winnerCount = winnerCount;
        this.price = price;
    }

    public static LottoEnum findByPrice(String winnerCount) {
        return Arrays.stream(LottoEnum.values())
                .filter(itemarray -> itemarray.hasDataGroup(winnerCount))
                .findAny()
                .orElse(EMPTY);
    }

    public boolean hasDataGroup(String winnerCount) {
        return this.winnerCount.contains(winnerCount);
    }

    public int getPrice() {
        return price;
    }

}
