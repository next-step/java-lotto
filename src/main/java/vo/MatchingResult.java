package vo;

public class MatchingResult {
    private final Rank rank;
    private int countOfMatchingLotto = 0;

    MatchingResult(Rank rank) {
        this.rank = rank;
    }

    boolean supports(Rank rank) {
        return this.rank == rank;
    }

    int match() {
        countOfMatchingLotto++;
        return countOfMatchingLotto;
    }

    public Money prizePerRank() {
        return rank.prize(countOfMatchingLotto);
    }

    public String getDisplayText() {
        return rank.getDisplayText();
    }

    public int getCountOfMatchingLotto() {
        return countOfMatchingLotto;
    }
}
