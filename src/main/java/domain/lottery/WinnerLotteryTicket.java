package domain.lottery;

import constant.Rank;

import static constant.LotteryRules.*;

public class WinnerLotteryTicket {
    private final LotteryTicket winnerLotteryTicket;
    private final int bonusTicketNumber;

    public WinnerLotteryTicket(LotteryTicket winnerTicket, int bonusTicketNumber) {
        this.winnerLotteryTicket = winnerTicket;
        this.bonusTicketNumber = bonusTicketNumber;
    }

    public boolean hasBonusTicketNumber(LotteryTicket lotteryTicket) {
        return lotteryTicket.getTicketNumbers().stream().anyMatch(number -> number == bonusTicketNumber);
    }

    public Rank findRank(LotteryTicket lotteryTicket) {
        int countOfMatchedNumber = (int) lotteryTicket.getTicketNumbers().stream().filter(winnerLotteryTicket.getTicketNumbers()::contains).count();
        if (lotteryTicket.getTicketNumbers().contains(bonusTicketNumber) && countOfMatchedNumber < NUMBER_OF_MATCHED_TICKET_NUMBER_FOR_FIRST_PLACE) countOfMatchedNumber += 2;
        switch (countOfMatchedNumber) {
            case NUMBER_OF_MATCHED_TICKET_NUMBER_FOR_FOURTH_PLACE:
                return Rank.FOURTH;
            case NUMBER_OF_MATCHED_TICKET_NUMBER_FOR_THIRD_PLACE:
                return Rank.THIRD;
            case NUMBER_OF_MATCHED_TICKET_NUMBER_FOR_SECOND_PLACE:
                return Rank.SECOND;
            case NUMBER_OF_MATCHED_TICKET_NUMBER_FOR_SECOND_WITH_BONUS_PLACE:
                return Rank.SECOND_WITH_BONUS;
            case NUMBER_OF_MATCHED_TICKET_NUMBER_FOR_FIRST_PLACE:
                return Rank.FIRST;
            default:
                return Rank.UNKNOWN;
        }
    }
}
