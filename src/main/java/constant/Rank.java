package constant;

import static constant.LotteryRules.*;

public class Rank {
    private final long countOfMatchedNumber;
    private final long reward;

    public Rank(long countOfMatchedNumber) {
        this.countOfMatchedNumber = countOfMatchedNumber;
        reward = 0L;
    }

    public Rank(long countOfMatchedNumber, long reward) {
        this.countOfMatchedNumber = countOfMatchedNumber;
        this.reward = reward;
    }

    public long getReward() {
        return reward;
    }

    public String findRank() {
        switch ((int) countOfMatchedNumber) {
            case NUMBER_OF_MATCHED_TICKET_NUMBER_FOR_FOURTH_PLACE:
                return "FOURTH";
            case NUMBER_OF_MATCHED_TICKET_NUMBER_FOR_THIRD_PLACE:
                return "THIRD";
            case NUMBER_OF_MATCHED_TICKET_NUMBER_FOR_SECOND_PLACE:
                return "SECOND";
            case NUMBER_OF_MATCHED_TICKET_NUMBER_FOR_FIRST_PLACE:
                return "FIRST";
            default:
                return "UNKNOWN";
        }
    }
}
