package lotto.model;

public enum Rank {
    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000),
    MISS(0, 0);

    private final int countOfMatch;
    private final int winningMoney;

    private Rank(int countOfMatch, int winningMoney) {
        this.countOfMatch = countOfMatch;
        this.winningMoney = winningMoney;
    }

    public int getCountOfMatch() {
        return countOfMatch;
    }

    public int getWinningMoney() {
        return winningMoney;
    }

    public static Rank valueOf(int countOfMatch, boolean matchBonus) {
        // TODO 일치하는 수를 로또 등수로 변경한다. enum 값 목록은 "Rank[] ranks = values();"와 같이 가져올 수 있다.
        if (countOfMatch<3) {
            return Rank.MISS;
        }

        if (countOfMatch == 3) {
            return Rank.FIFTH;
        }

        if (countOfMatch == 4) {
            return Rank.FOURTH;
        }

        if (countOfMatch == 5) {
            return checkBonus(matchBonus);
        }

        if (countOfMatch == 6) {
            return Rank.FIRST;
        }

        throw new IllegalArgumentException("매치하는 숫자가 올바르지 않습니다.");
    }

    private static Rank checkBonus(boolean matchBonus) {
        if (matchBonus) {
            return Rank.SECOND;
        }
        return Rank.THIRD;
    }
}
