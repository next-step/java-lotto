package step2.model;

import java.util.Arrays;

public enum Rank {
    FIRST(6, false, 2_000_000_000, "6개 일치 (2000000000원)"),
    SECOND(5,true,  30_000_000, "5개 일치, 보너스 볼 일치(30000000원)"),
    THIRD(5, false, 15_000_000, "5개 일치 (1500000원)"),
    FOURTH(4,false,  50000, "4개 일치 (50000원)"),
    FIFTH(3, false, 5000, "3개 일치 (5000원)"),
    MISS(0, false, 0, "불일");

    private int countOfMatch;
    private boolean isBonus;
    private int winningPrice;
    private String message;

    Rank(int countOfMatch, boolean isBonus, int winningPrice, String message) {
        this.countOfMatch = countOfMatch;
        this.isBonus = isBonus;
        this.winningPrice = winningPrice;
        this.message = message;
    }

    public int getCountOfMatch() {
        return countOfMatch;
    }

    public int getWinningPrice() {
        return winningPrice;
    }

    public String getMessage() {
        return message;
    }

    public boolean getBonus() {
        return isBonus;
    }

    public static Rank getRank(int countOfMatch, boolean matchBonus){
        return Arrays.stream(Rank.values())
                    .filter(rank -> (countOfMatch == rank.getCountOfMatch() && matchBonus == rank.getBonus()))
                    .findAny()
                    .orElse(MISS);
    }
}
