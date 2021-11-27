package domain;

import java.util.Collections;
import java.util.List;

public class LotteryTicket {
    private static final int BONUS_BULL_CHECK_NUMBER = 5;
    private static final int BONUS_BALL_ZERO = 0;

    private final List<LotteryNumber> lotteryTicket;

    public LotteryTicket(List<LotteryNumber> lotteryTicket) {
        this.lotteryTicket = Collections.unmodifiableList(lotteryTicket);
    }

    public int matchCount(WinningLottery winningLottery) {
        return (int) lotteryTicket.stream()
                .filter(number -> winningLottery.matchLottery(number.value()))
                .count();
    }

    public int matchBonusBall(int rank, WinningLottery winningLottery) {
        if (rank != BONUS_BULL_CHECK_NUMBER) {
            return BONUS_BALL_ZERO;
        }

        return (int) lotteryTicket.stream()
                .filter(number -> winningLottery.matchBonusBall(number.value()))
                .count();
    }

    public int value(int index){
        return lotteryTicket.get(index).value();
    }

    public int size() {
        return lotteryTicket.size();
    }
}
