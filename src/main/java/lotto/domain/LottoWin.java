package lotto.domain;

public enum LottoWin {
    MISS(0, 0),
    FIFTH(3, 5_000),
    FOURTH(4, 50_000),
    THIRD(5, 1_500_000),
    SECOND(5, 30_000_000),
    FIRST(6, 2_000_000_000);

    private int countOfMatch;
    private int earning;

    LottoWin(int countOfMatch, int earning) {
        this.countOfMatch = countOfMatch;
        this.earning = earning;
    }

    public int getCountOfMatch() {
        return countOfMatch;
    }

    public int getEarning() {
        return earning;
    }

    public static LottoWin valueOf(int countOfMatch, boolean matchBonus) {
        for (LottoWin lottoWin : values()) {
            if (lottoWin.countOfMatch == 5 && matchBonus) {
                return SECOND;
            }

            if (lottoWin.countOfMatch == countOfMatch) {
                return lottoWin;
            }
        }

        return MISS;
    }

}
