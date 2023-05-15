package lotto.model;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import static lotto.constant.LotteryConstant.*;

public class WinNumbers {

    private Set<LotteryNumber> numbers;
    private int bonusNumber;

    public WinNumbers(Set<Integer> numbers) {
        validate(numbers, bonusNumber);
        this.numbers = numbers.stream().map(LotteryNumber::of).collect(Collectors.toSet());
    }

    public WinNumbers(Set<Integer> numbers, int bonusNumber) {
        validate(numbers, bonusNumber);
        this.numbers = numbers.stream().map(LotteryNumber::of).collect(Collectors.toSet());
        this.bonusNumber = bonusNumber;
    }

    private void validate(Set<Integer> numbers, int bonusNumber) {
        if (numbers.size() != NUMBER_PER_TICKET || bonusNumber > LOTTERY_MAX || bonusNumber <  LOTTERY_MIN) {
            throw new RuntimeException("잘못된 로또 번호 목록입니다. : " + numbers);
        }
    }

    public int matchCount(Set<LotteryNumber> others) {
        Set<LotteryNumber> intersection = new HashSet<>(numbers);
        intersection.retainAll(others);
        return intersection.size();
    }

}
