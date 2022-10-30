package constant;

import static constant.LotteryRules.*;

public enum Prize {
    FIRST(new Rank(NUMBER_OF_MATCHED_TICKET_NUMBER_FOR_FIRST_PLACE, REWARD_OF_FIRST_PLACE)),
    SECOND(new Rank(NUMBER_OF_MATCHED_TICKET_NUMBER_FOR_SECOND_PLACE, REWARD_OF_SECOND_PLACE)),
    THIRD(new Rank(NUMBER_OF_MATCHED_TICKET_NUMBER_FOR_THIRD_PLACE, REWARD_OF_THIRD_PLACE)),
    FOURTH(new Rank(NUMBER_OF_MATCHED_TICKET_NUMBER_FOR_FOURTH_PLACE, REWARD_OF_FOURTH_PLACE)),
    UNKNOWN(new Rank(NUMBER_OF_MATCHED_TICKET_NUMBER_FOR_UNKNOWN, REWARD_OF_UNKNOWN));

    public final Rank rank;

    Prize(Rank rank) {
        this.rank = rank;
    }

    public long getPrize() {
        return rank.getReward();
    }
}
