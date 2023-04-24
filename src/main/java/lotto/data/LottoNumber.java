package lotto.data;

import java.util.Arrays;

public enum LottoNumber {
    MATCHED_0(0, 0),
    MATCHED_1(1, 0),
    MATCHED_2(2, 0),
    MATCHED_3(3, 5000),
    MATCHED_4(4, 50000),
    MATCHED_5(5, 1500000),
    MATCHED_6(6, 2000000000);

    private int matchedNumber;
    private int winningPrice;

    LottoNumber(int matchedNumber, int winningPrice) {
        this.matchedNumber = matchedNumber;
        this.winningPrice = winningPrice;
    }

    public int getMatchedNumber() {
        return this.matchedNumber;
    }

    public int getWinningPrice() {
        return this.winningPrice;
    }

    public static LottoNumber getLottoNumberByNumber(int number) {
        return Arrays.stream(LottoNumber.values())
                .filter(lottoNumber -> lottoNumber.getMatchedNumber() == number)
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException());
    }
}
