package domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class LotteryTicket {
    private static final int BONUS_BULL_CHECK_NUMBER = 5;
    private static final int BONUS_BALL_ZERO = 0;

    private final List<LotteryNumber> lotteryTicket;

    public LotteryTicket(List<Integer> lotteryTicket) {
        this.lotteryTicket = Collections.unmodifiableList(changeToLotteryNumber(lotteryTicket));
    }

    public static List<LotteryNumber> changeToLotteryNumber(List<Integer> lotteryTicket) {
        return lotteryTicket.stream()
                .map(LotteryNumber::new)
                .collect(Collectors.toList());
    }

    public int getLotteryNumber(int index) {
        return lotteryTicket.get(index).value();
    }

    public int matchCount(LastWeekLottery lastWeekLottery) {
        return (int) lotteryTicket.stream()
                .filter(number -> checkMatchCount(number.value(), lastWeekLottery))
                .count();
    }

    private boolean checkMatchCount(int number, LastWeekLottery lastWeekLottery) {
        if (lastWeekLottery.matchNumber(number) > 0) {
            return true;
        }
        return false;
    }

    public int matchBonusBall(int rank, int bonusBall) {
        if (rank != BONUS_BULL_CHECK_NUMBER) {
            return BONUS_BALL_ZERO;
        }

        return (int) lotteryTicket.stream()
                .filter(number -> validBonusBall(number.value(), bonusBall))
                .count();
    }

    private boolean validBonusBall(int lotteryNumber, int bonusBall) {
        if (lotteryNumber == bonusBall) {
            return true;
        }
        return false;
    }

    public int size() {
        return lotteryTicket.size();
    }
}
