package domain;

import java.util.*;
import java.util.stream.Collectors;

public class LotteryTicket {
    private static final int BONUS_BULL_CHECK_NUMBER = 5;
    private static final int BONUS_BALL_ZERO = 0;
    private static final int LOTTERY_END_SIZE = 6;
    private static final String LOTTERY_SIZE_ERROR_MESSAGE = "error : 로또번호는 6개 입니다.";

    private final Set<LotteryNumber> lotteryTicket;

    public LotteryTicket(Set<LotteryNumber> lotteryTicket) {
        this.lotteryTicket = Collections.unmodifiableSet(lotteryTicket);
    }

    public int matchCount(WinningLottery winningLottery) {
        return (int) lotteryTicket.stream()
                .filter(number -> winningLottery.matchLottery(number))
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

    public static LotteryTicket from(Set<LotteryNumber> lottery) {
        return new LotteryTicket(lottery);
    }

    public static Set<LotteryNumber> validLotteryNumber(Set<Integer> manualNumber) {
        validLotterySize(manualNumber.size());

        return Collections.unmodifiableSet(manualNumber.stream()
                .map(LotteryNumber::new)
                .collect(Collectors.toSet()));
    }

    private static void validLotterySize(int size) {
        if (size != LOTTERY_END_SIZE) {
            throw new IllegalArgumentException(LOTTERY_SIZE_ERROR_MESSAGE);
        }
    }

    public Set<LotteryNumber> bringLottery() {
        return lotteryTicket;
    }

    public int size() {
        return lotteryTicket.size();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LotteryTicket that = (LotteryTicket) o;
        return Objects.equals(lotteryTicket, that.lotteryTicket);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lotteryTicket);
    }
}
