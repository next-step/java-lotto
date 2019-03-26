package lottery.domain;

import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@EqualsAndHashCode
@ToString
public class LotteryNumber {

    public static final int ONE_GAME_NUMBERS_SIZE = 6;
    private List<Integer> numbers;
    private Integer bonusNumber = 0;

    public LotteryNumber() {
        extractRandomNumbers();
    }

    // TODO : 나중에 수동용 생기면 할 것
    public LotteryNumber(List<Integer> inputNumbers) {
        if(inputNumbers.size() != ONE_GAME_NUMBERS_SIZE) {
            throw new IllegalArgumentException("잘못 입력하신 것 같군요..");
        }
        numbers = inputNumbers;
    }

    public LotteryNumber(List<Integer> inputNumbers, int bonusNumber) {
        if(inputNumbers.size() != ONE_GAME_NUMBERS_SIZE) {
            throw new IllegalArgumentException("잘못 입력하신 것 같군요..");
        }
        if(inputNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("중복은 안돼요");
        }
        numbers = inputNumbers;
        this.bonusNumber = bonusNumber;
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

    public int compareNumbers(LotteryNumber winningLotteryNumber) {
        int count = 0;
        int bonusballReturn = 51;
        for(int number : winningLotteryNumber.numbers) {
            count = getCount(count, number);
        }
        if (checkBonusNumber(winningLotteryNumber, count)) return bonusballReturn;
        return count;
    }

    private int getCount(int count, int number) {
        if(isContains(number)) {
            count++;
        }
        return count;
    }

    private boolean checkBonusNumber(LotteryNumber winningLotteryNumber, int count) {
        if(count == 5) {
            return isContains(winningLotteryNumber.bonusNumber);
        }
        return false;
    }

    private boolean isContains(int number) {
        return numbers.contains(number);
    }
}
