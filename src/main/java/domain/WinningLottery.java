package domain;

import java.util.Set;
import java.util.stream.Collectors;

public class WinningLottery {
    private static final String LOTTERY_NUMBER_LACK_ERROR_MESSAGE = "error : 로또 번호는 중복되지 않는 번호 6개 입니다.";
    private static final int LOTTERY_SIZE_MAX = 6;
    private static final boolean MATCH_NUMBER_TRUE = true;
    private static final boolean MATCH_NUMBER_FALSE = false;

    private final Set<LotteryNumber> winningLottery;
    private final int bonusBall;

    public WinningLottery(Set<Integer> numbers, int bonusBall) {
        this.winningLottery = changeToLotteryNumber(numbers);
        this.bonusBall = bonusBall;
    }

    public Set<LotteryNumber> changeToLotteryNumber(Set<Integer> numbers) {
        validWinningLottery(numbers.size());

        return of(numbers);
    }

    private void validWinningLottery(int count) {
        if (count < LOTTERY_SIZE_MAX) {
            throw new IllegalArgumentException(LOTTERY_NUMBER_LACK_ERROR_MESSAGE);
        }
    }

    private Set<LotteryNumber> of(Set<Integer> numbers) {
        return numbers.stream()
                .map(LotteryNumber::new)
                .collect(Collectors.toSet());
    }

    public boolean matchLottery(int lotteryNumber) {
        return winningLottery.stream()
                .anyMatch(number -> validLotteryNumber(number.value(), lotteryNumber));
    }

    private boolean validLotteryNumber(int winningNumber, int lotteryNumber) {
        if (winningNumber == lotteryNumber) {
            return MATCH_NUMBER_TRUE;
        }
        return MATCH_NUMBER_FALSE;
    }

    public boolean matchBonusBall(int lotteryNumber) {
        if (lotteryNumber == bonusBall) {
            return MATCH_NUMBER_TRUE;
        }
        return MATCH_NUMBER_FALSE;
    }

    public int size() {
        return winningLottery.size();
    }
}
