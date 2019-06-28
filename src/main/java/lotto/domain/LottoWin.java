package lotto.domain;

public class LottoWin {
    private static int WIN_EARNING_BY_THREE = 5000;
    private static int WIN_EARNING_BY_FOUR = 50000;
    private static int WIN_EARNING_BY_FIVE = 1500000;
    private static int WIN_EARNING_BY_SIX = 2000000000;

    private int matchCount;

    public LottoWin(int matchCount) {
        this.matchCount = matchCount;
    }

    public int getEarning() {
        switch (matchCount) {
            case 3:
                return WIN_EARNING_BY_THREE;
            case 4:
                return WIN_EARNING_BY_FOUR;
            case 5:
                return WIN_EARNING_BY_FIVE;
            case 6:
                return WIN_EARNING_BY_SIX;
        }

        return 0;
    }
}
