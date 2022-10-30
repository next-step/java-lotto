package constant;

import static constant.LotteryRules.*;

public class Rank {
    private final int countOfMatchedNumber;
    private final boolean isMatchedWithBonusTicketNumber;
    private final long reward;

    public Rank(int countOfMatchedNumber, boolean isMatchedWithBonusTicketNumber) {
        this.countOfMatchedNumber = countOfMatchedNumber;
        this.isMatchedWithBonusTicketNumber = isMatchedWithBonusTicketNumber;
        reward = 0L;
    }

    public Rank(int countOfMatchedNumber, long reward) {
        this.countOfMatchedNumber = countOfMatchedNumber;
        this.isMatchedWithBonusTicketNumber = false;
        this.reward = reward;
    }

    public long getReward() {
        return reward;
    }

    public String findRank() {
        switch (countOfMatchedNumber) {
            case NUMBER_OF_MATCHED_TICKET_NUMBER_FOR_FOURTH_PLACE:
                return "FOURTH";
            case NUMBER_OF_MATCHED_TICKET_NUMBER_FOR_THIRD_PLACE:
                return "THIRD";
            case NUMBER_OF_MATCHED_TICKET_NUMBER_FOR_SECOND_PLACE:
                if (isMatchedWithBonusTicketNumber) return "SECOND_WITH_BONUS";
                return "SECOND";
            case NUMBER_OF_MATCHED_TICKET_NUMBER_FOR_FIRST_PLACE:
                return "FIRST";
            default:
                return "UNKNOWN";
        }
    }
}
