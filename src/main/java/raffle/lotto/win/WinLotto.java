package raffle.lotto.win;

import java.util.Arrays;

public enum WinLotto {

    ZERO_LOTTO(0, 0),
    ONE_LOTTO(1, 0),
    TWO_LOTTO(2, 0),
    THREE_WIN_LOTTO(3, 5000),
    FOUR_WIN_LOTTO(4, 50000),
    FIVE_WIN_LOTTO(5, 1500000),
    SIX_WIN_LOTTO(6, 2000000000);

    int winCount;
    int price;

    WinLotto(int winCount, int price) {
        this.winCount = winCount;
        this.price = price;
    }

    public static WinLotto search(long count) {
        return Arrays.stream(values())
                    .filter(winLotto -> winLotto.match(count))
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
