package lottoModel;

public enum Rank {
    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000),
    MISS(0, 0);

    private int countOfMatch;
    private int winningMoney;

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
        // 모든 Rank 값들을 배열로 가져옴
        Rank[] ranks = values();

        // 보너스 매치가 있고, 매치 수가 5인 경우 SECOND를 반환
        if (countOfMatch == 5 && matchBonus) {
            return SECOND;
        }

        // 다른 일반적인 경우에 대한 처리
        for (Rank rank : ranks) {
            if (rank.getCountOfMatch() == countOfMatch && rank != SECOND) {
                return rank;
            }
        }

        // 일치하는 등급이 없는 경우 MISS 반환
        return MISS;
    }
}
