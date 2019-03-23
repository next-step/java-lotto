package lottery.domain;

import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@EqualsAndHashCode
@ToString
//TODO : 사이즈 6인 것 체크하는 로직 필요
public class LotteryNumber {

    private List<Integer> numbers;

    public LotteryNumber() {
        extractRandomNumbers();
    }

    public LotteryNumber(List<Integer> inputNumbers) {
        System.out.println("하 제발요 ㅠㅠ " + inputNumbers.toString());
        numbers = inputNumbers;
    }

    public List<Integer> extractRandomNumbers() {
        numbers = sort(splitNumbers(suffle(LotteryNumberSet.lotteryNumbers)));
        System.out.println("이번엔 여기가?   " + numbers.toString());
        return numbers;
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
        return suffledNumbers.subList(0, 6);
    }

    public int countMatchedNumber(int matchedNumberCount, int winningNumber) {
        if(isContains(numbers, winningNumber)) {
            matchedNumberCount++;
        }
        return matchedNumberCount;
    }

    private boolean isContains(List<Integer> lotteryNumbers,int winningNumber) {
        if(lotteryNumbers.contains(winningNumber)) {
            return true;
        }
        return false;
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
