package lottery.domain;

import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.*;

@EqualsAndHashCode
@ToString
public class LotteryNumber {
    private static final int BETWEEN_NUMBER_MIN = 0;
    private static final int BETWEEN_NUMBER_MAX = 46;
    private static final int SECOND_RANK_CHECK_VALUE = 5;
    private static final int ONE_GAME_NUMBERS_SIZE = 6;
    private List<Integer> numbers;
    private int bonusNumber;

    public LotteryNumber() {
        extractRandomNumbers();
    }

    public LotteryNumber(List<Integer> inputNumbers) throws IllegalArgumentException {
        if(isSizeCorrect(inputNumbers)) {
            throw new IllegalArgumentException("잘못 입력하신 것 같군요..");
        }

        if(isDuplicate(inputNumbers)) {
            throw new IllegalArgumentException("중복은 안돼요!");
        }

        if(isNotBetween(inputNumbers)) {
            throw new IllegalArgumentException("숫자가 1~45인지 체크해주세요!");
        }
        numbers = inputNumbers;
    }

    public LotteryNumber(List<Integer> inputNumbers, int bonusNumber) {
        this(inputNumbers);
        if(inputNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("보너스 번호 중복은 안돼요");
        }
        this.bonusNumber = bonusNumber;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public boolean isSizeCorrect(Collection value) {
        return value.size() != ONE_GAME_NUMBERS_SIZE;
    }

    public boolean isDuplicate(List<Integer> inputNumbers) {
        return isSizeCorrect(new HashSet<>(inputNumbers));
    }

    public boolean isNotBetween(List<Integer> inputNumbers) {
        for (Integer inputNumber : inputNumbers) {
            if(BETWEEN_NUMBER_MIN > inputNumber | BETWEEN_NUMBER_MAX < inputNumber) {
                return true;
            }
        }
        return false;
    }

    public List<Integer> extractRandomNumbers() {
        return sort(splitNumbers(suffle(LotteryNumberSet.lotteryNumbers)));
    }

    List<Integer> suffle(List<Integer> lotteryNumbers) {
        Collections.shuffle(lotteryNumbers);
        return lotteryNumbers;
    }
    private List<Integer> sort(List<Integer> suffledNumbers) {
        Collections.sort(suffledNumbers);
        return suffledNumbers;
    }

    private List<Integer> splitNumbers(List<Integer> suffledNumbers) {
        this.numbers = new ArrayList<>(suffledNumbers.subList(0, 6));
        return numbers;
    }

    public String getStringForPrint() {
        return numbers.toString();
    }

    public RANK compareNumbers(LotteryNumber winningLotteryNumber) {
        int count = countMatchedNumbers(winningLotteryNumber);
        if (checkBonusNumber(winningLotteryNumber, count)) return RANK.SECOND;

        for(RANK rank : RANK.values()) {
            if(count == rank.getMatched()) {
                return rank;
            }
        }
        return RANK.MISS;
    }

    public int countMatchedNumbers(LotteryNumber winningLotteryNumber) {
        int count = 0;
        for(int number : winningLotteryNumber.numbers) {
            count = countMatchedNumber(count, number);
        }
        return count;
    }

    private int countMatchedNumber(int count, int number) {
        if(isContains(number)) {
            count++;
        }
        return count;
    }

    private boolean checkBonusNumber(LotteryNumber winningLotteryNumber, int count) {
        if(count == SECOND_RANK_CHECK_VALUE) {
            return isContains(winningLotteryNumber.bonusNumber);
        }
        return false;
    }

    private boolean isContains(int number) {
        return numbers.contains(number);
    }
}
