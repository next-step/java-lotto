package domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class RankGroup {
    private static final int LOTTERY_SIZE_MIN = 1;
    private static final int LOTTERY_SIZE_MAX = 6;
    private static final String NUMBER_SIZE_ERROR_MESSAGE = "error : 로또번호는 1이상 6이하 입니다.";
    private static final int BONUS_BALL_MIN = 0;
    private static final int BONUS_BALL_MAX = 1;
    private static final String BONUS_BALL_ERROR_MESSAGE = "error : 보너스 볼 은 0이나 1개만 존재할 수 없습니다.";

    private final List<Rank> rankGroup;

    public RankGroup(LotteryTicket lottery, LastWeekLottery lastWeekLottery, int bonusBall) {
        this(winningNumberList(lottery, lastWeekLottery, bonusBall));
    }

    public RankGroup(LotteryTickets lottery, LastWeekLottery lastWeekLottery, int bonusBall) {
        this(winningNumberList(lottery, lastWeekLottery, bonusBall));
    }

    private RankGroup(List<Rank> rankGroup) {
        this.rankGroup = Collections.unmodifiableList(rankGroup);
    }

    private static List<Rank> winningNumberList(LotteryTickets lotteryTickets, LastWeekLottery lastWeekLottery, int bonusBall) {
        List<Rank> numbers = new ArrayList<>();
        int loopNumber = lotteryTickets.size();
        int rank;
        int bonus;
        for (int i = 0; i < loopNumber; i++) {
            rank = lotteryTickets.matchLottery(i, lastWeekLottery);
            bonus = lotteryTickets.matchBonusBoll(i, rank, bonusBall);
            numbers.add(new Rank(rank, bonus));
        }
        return numbers;
    }

    private static List<Rank> winningNumberList(LotteryTicket lotteryTicket, LastWeekLottery lastWeekLottery, int bonusBall) {
        int rank = lotteryTicket.matchCount(lastWeekLottery);
        int bonus = lotteryTicket.matchBonusBall(rank, bonusBall);

        return Arrays.asList(new Rank(rank, bonus));
    }

    public int rank(int index) {
        return rankGroup.get(index).rank();
    }

    public int bonusBoll(int index) {
        return rankGroup.get(index).bonusBall();
    }

    public int count(int rank, int bonusBall) {
        checkRankSize(rank);
        checkBonusBallSize(bonusBall);
        return (int) rankGroup.stream()
                .filter(winner -> validRank(winner.rank(), rank, winner.bonusBall(), bonusBall))
                .count();
    }

    private void checkRankSize(int rank) {
        if (rank < LOTTERY_SIZE_MIN || rank > LOTTERY_SIZE_MAX) {
            throw new IllegalArgumentException(NUMBER_SIZE_ERROR_MESSAGE);
        }
    }

    private void checkBonusBallSize(int bonusBall) {
        if (bonusBall < BONUS_BALL_MIN || bonusBall > BONUS_BALL_MAX) {
            throw new IllegalArgumentException(BONUS_BALL_ERROR_MESSAGE);
        }
    }

    private boolean validRank(int lotteryRank, int rank, int lotteryBonusBall, int bonusBall) {
        if (lotteryRank == rank && lotteryBonusBall == bonusBall) {
            return true;
        }
        return false;
    }

    public int size() {
        return rankGroup.size();
    }

    public int moneyPrizeRank(int rank, int bonusBall) {
        return LotteryPrizeCalculation.winningAmount(rank, bonusBall);
    }

}
