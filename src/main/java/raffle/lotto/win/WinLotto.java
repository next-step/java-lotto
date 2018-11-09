package raffle.lotto.win;

import java.util.Arrays;

public enum WinLotto {

    SIX_WIN_LOTTO(6, 2000000000),
    FIVE_WIN_BONUS_LOTTO(5, 30000000),
    FIVE_WIN_LOTTO(5, 1500000),
    FOUR_WIN_LOTTO(4, 50000),
    THREE_WIN_LOTTO(3, 5000),
    TWO_LOTTO(2, 0),
    ONE_LOTTO(1, 0),
    ZERO_LOTTO(0, 0);

    private int winCount;
    private int price;

    WinLotto(int winCount, int price) {
        this.winCount = winCount;
        this.price = price;
    }

    public static WinLotto search(long count, boolean hasBonus) {
        return Arrays.stream(values())
                    .filter(winLotto -> winLotto.match(count))
                    .filter(winLotto -> !winLotto.equals(FIVE_WIN_BONUS_LOTTO) || hasBonus)
                    .findFirst()
                    .orElseThrow(() -> new IllegalArgumentException("상금이 존재하지 않습니다."));
    }

    private boolean match(long count) {
        return this.winCount == count;
    }

    public int getPrice() {
        return price;
    }

    public int getWinCount() {
        return winCount;
    }
}
