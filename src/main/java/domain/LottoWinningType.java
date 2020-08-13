package domain;

import java.util.Arrays;

public enum LottoWinningType {
    FIRST_WINNING(6, 2_000_000_000),
    SECOND_WINNING(5, 1_500_000),
    THIRD_WINNING(4, 50_000),
    FORTH_WINNING(3, 5_000),
    NOTHING(0, 0);

    private final int hitNumber;
    private final LottoMoney lottoMoney;

    LottoWinningType(int hitNumber, int lottoMoney) {
        this.hitNumber = hitNumber;
        this.lottoMoney = new LottoMoney(lottoMoney);
    }

    public LottoMoney getLottoMoney() {
        return lottoMoney;
    }

    public int getHitNumber() {
        return hitNumber;
    }

    public static LottoWinningType getWinningType(int hitNumber) {
        return Arrays.stream(LottoWinningType.values())
                .filter(e -> e.hitNumber == hitNumber)
                .findFirst()
                .orElse(NOTHING);
    }
}
