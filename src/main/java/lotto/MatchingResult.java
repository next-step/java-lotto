package lotto;

import java.math.BigDecimal;

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
        return ++countOfMatchingLotto;
    }

    public BigDecimal prizePerRank() {
        return rank.prize(countOfMatchingLotto);
    }

    public String getDisplayText() {
        String text;
        switch (rank) {
            case FIRST_PLACE:
                text = "6개 일치 (2000000000원)";
                break;
            case SECOND_PLACE:
                text = "5개 일치 (1500000원)";
                break;
            case THIRD_PLACE:
                text = "4개 일치 (50000원)";
                break;
            case FOURTH_PLACE:
                text = "3개 일치 (5000원)";
                break;
            case FAILURE:
                text = "0";
                break;
            default:
                text = "";
        }
        return text;
    }

    public int getCountOfMatchingLotto() {
        return countOfMatchingLotto;
    }
}
