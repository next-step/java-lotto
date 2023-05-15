package lotto.model;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import static lotto.constant.LotteryConstant.NUMBER_PER_TICKET;

public class WinNumbers {

    private Set<LotteryNumber> numbers;

    public WinNumbers(Set<Integer> numbers) {
        if (numbers.size() != NUMBER_PER_TICKET) {
            throw new RuntimeException("잘못된 로또 번호 목록입니다. : " + numbers);
        }
        this.numbers = numbers.stream().map(LotteryNumber::of).collect(Collectors.toSet());
    }

    public int matchCount(Set<LotteryNumber> others) {
        Set<LotteryNumber> intersection = new HashSet<>(numbers);
        intersection.retainAll(others);
        return intersection.size();
    }

}
