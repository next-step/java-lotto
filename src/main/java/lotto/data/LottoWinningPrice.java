package lotto.data;

import java.util.Arrays;
import java.util.stream.DoubleStream;

public enum LottoWinningPrice {
    MATCHED_0(0, false, 0),
    MATCHED_1(1, false, 0),
    MATCHED_2(2, false ,0),
    MATCHED_3(3, false ,5_000),
    MATCHED_4(4, false, 50_000),
    MATCHED_5(5, false, 1_500_000),
    MATCHED_5_BONUS(5, true, 30_000_000),
    MATCHED_6(6, false, 2_000_000_000);

    private int matchedNumber;
    private boolean matchedBonusNumber;
    private int winningPrice;

    LottoWinningPrice(int matchedNumber, boolean matchedBonusNumber, int winningPrice) {
        this.matchedNumber = matchedNumber;
        this.matchedBonusNumber = matchedBonusNumber;
        this.winningPrice = winningPrice;
    }

    public int getMatchedNumber() {
        return this.matchedNumber;
    }

    public boolean getMatchedBonusNumber() {
        return this.matchedBonusNumber;
    }

    public int getWinningPrice() {
        return this.winningPrice;
    }

    public static LottoWinningPrice getLottoNumberByNumber(int number, boolean bonusNumber) {
        return Arrays.stream(LottoWinningPrice.values())
                .filter(lottoWinningPrice -> lottoWinningPrice.isMatch(number, bonusNumber))
                .findAny()
                .orElseThrow(IllegalArgumentException::new);
    }

    private boolean isMatch(int number, boolean bonusNumber) {
        return this.matchedNumber == number && this.matchedBonusNumber == bonusNumber;
    }
}
