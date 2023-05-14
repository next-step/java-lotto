package lotto.domain.result;

public class LottoResult {
    private final Rank rank;
    private final WinCount winCount;

    public LottoResult(Rank rank, WinCount winCount) {
        this.rank = rank;
        this.winCount = winCount;
    }

    public static LottoResult of(Rank rank) {
        return new LottoResult(rank, new WinCount(0));
    }

    public void win(Rank rank) {
        if (rank != this.rank) {
            return;
        }
        winCount.plusOne();
    }

    public int getHit() {
        return rank.getHit();
    }

    public int getReward() {
        return rank.getReward();
    }

    public int getNumberOfWin() {
        return winCount.getNumberOfWin();
    }

    public int getTotalPrice() {
        return rank.getReward() * winCount.getNumberOfWin();
    }

    @Override
    public String toString() {
        return "LottoResult{" +
                "rank=" + rank +
                ", winCount=" + winCount +
                '}';
    }
}
