package domain;

import java.util.Arrays;

public enum LottoUnitWinnings {
    THREE(3, new Price(5000L)),
    FOUR(4, new Price(50000L)),
    FIVE(5, new Price(1500000L)),
    SIX(6, new Price(2000000000L));

    private final Integer equalCount;
    private final Price winningPrice;

    LottoUnitWinnings(int equalCount, Price winningPrice) {
        this.equalCount = equalCount;
        this.winningPrice = winningPrice;
    }

    public Price getWinningPrice() {
        return this.winningPrice;
    }

    public Integer getEqualCount() {
        return this.equalCount;
    }


    public static Price findWinningPrice(long equalCount) {
        return Arrays.stream(LottoUnitWinnings.values())
                .filter(lottoUnitWinning -> lottoUnitWinning.getEqualCount() == equalCount)
                .map(lottoUnitWinning -> lottoUnitWinning.getWinningPrice())
                .findAny()
                .orElseGet(() -> new Price(0L));
    }
}
