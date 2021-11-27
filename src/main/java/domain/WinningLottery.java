package domain;

import java.util.Set;
import java.util.stream.Collectors;

public class WinningLottery {
    private static final String LOTTERY_NUMBER_LACK_ERROR_MESSAGE = "error : 로또 번호는 중복되지 않는 번호 6개 입니다.";
    private static final int LOTTERY_SIZE_MAX = 6;
    private static final boolean MATCH_NUMBER_TRUE = true;
    private static final boolean MATCH_NUMBER_FALSE = false;
    private static final String OVERLAP_ERROR_MESSAGE = "error : 당첨번호 와 보너스볼 은 중복될수 없습니다.";

    private final Set<LotteryNumber> winningLottery;
    private final int bonusBall;

    public WinningLottery(Set<Integer> numbers, int bonusBall) {
        this.winningLottery = changeToLotteryNumber(numbers);
        this.bonusBall = validBonusBall(bonusBall);
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

    private int validBonusBall(int bonusBall){
        for(LotteryNumber number : winningLottery){
            checkOverlap(number.value(), bonusBall);
        }
        return bonusBall;
    }

    private void checkOverlap(int lotteryNumber, int bonusBall){
        if(lotteryNumber == bonusBall){
            throw new IllegalArgumentException(OVERLAP_ERROR_MESSAGE);
        }
    }

    public boolean matchLottery(LotteryNumber lotteryNumber) {
        return winningLottery.contains(lotteryNumber);
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
