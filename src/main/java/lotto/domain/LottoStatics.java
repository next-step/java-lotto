package lotto.domain;

import java.util.Arrays;

public enum LottoStatics {

    THREE(3, 5000, 0),
    FOUR(4, 50000, 0),
    FIVE(5, 1500000, 0),
    SIX(6, 2000000000, 0)
    ;

    private final long winningMatchCount;
    private final int money;
    private int count;

    LottoStatics(long winningMatchCount, int money, int count) {
        this.winningMatchCount = winningMatchCount;
        this.money = money;
        this.count = count;
    }

    public long getWinningMatchCount() {
        return winningMatchCount;
    }

    public int getMoney() {
        return money;
    }

    public int getCount() {
        return count;
    }

    public static void setLottoStatics(Long count) {
        LottoStatics lottoStatics = Arrays.stream(values())
                .filter(lottoStatic -> lottoStatic.winningMatchCount == count)
                .findFirst()
                .get();

        lottoStatics.count++;
    }

    public static int getWinningPrize() {
        return Arrays.stream(values())
                .map(lottoStatics -> lottoStatics.getMoney() * lottoStatics.getCount())
                .reduce(0, (Integer::sum));
    }
}
