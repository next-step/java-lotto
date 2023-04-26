package lotto.data;

import java.util.Arrays;

public enum LottoWinningPrice {
    MATCHED_0(0, 0),
    MATCHED_1(1, 0),
    MATCHED_2(2, 0),
    MATCHED_3(3, 5_000),
    MATCHED_4(4, 50_000),
    MATCHED_5(5, 1_500_000),
    MATCHED_6(6, 2_000_000_000);

    private int matchedNumber;
    private int winningPrice;

    LottoWinningPrice(int matchedNumber, int winningPrice) {
        this.matchedNumber = matchedNumber;
        this.winningPrice = winningPrice;
    }

    public int getMatchedNumber() {
        return this.matchedNumber;
    }

    public int getWinningPrice() {
        return this.winningPrice;
    }

    public static LottoWinningPrice getLottoNumberByNumber(int number) {
        return Arrays.stream(LottoWinningPrice.values())
                .filter(lottoWinningPrice -> lottoWinningPrice.getMatchedNumber() == number)
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException());
    }
}
