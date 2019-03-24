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

    public LotteryNumber() {
        extractRandomNumbers();
    }

    public LotteryNumber(List<Integer> inputNumbers) {
        if(inputNumbers.size() != ONE_GAME_NUMBERS_SIZE) {
            throw new IllegalArgumentException("잘못 입력하신 것 같군요..");
        }
        numbers = inputNumbers;
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

    // 같은 값이 많으면 숫자가 작음 ex) 1등 = 1
    public int compareNumbers(LotteryNumber winningLotteryNumber) {
        int defualtSetValue = 1;
        List<Integer> results = new ArrayList<>(winningLotteryNumber.numbers);
        results.removeAll(numbers);
        return results.size() + defualtSetValue;
    }
}
