package lotto.model;

import lotto.util.RandomNumberGenerator;

import java.util.ArrayList;
import java.util.List;

public class LotteryTicket {

    private static final int NUMBER_PER_TICKET = 6;

    private List<LotteryNumber> numbers;

    public LotteryTicket() {
        List<LotteryNumber> numbers = new ArrayList<>();
        while (numbers.size() < NUMBER_PER_TICKET) {
            LotteryNumber newNumber = LotteryNumber.of(new RandomNumberGenerator());
            addIfNotExist(numbers, newNumber);
        }
        validate(numbers);
        this.numbers = numbers;
    }

    public LotteryTicket(List<LotteryNumber> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void addIfNotExist(List<LotteryNumber> numbers, LotteryNumber newNumber) {
        if (!numbers.contains(newNumber)) {
            numbers.add(newNumber);
        }
    }

    private void validate(List<LotteryNumber> numbers) {
        if (numbers.size() != NUMBER_PER_TICKET || numbers.stream().distinct().count() != NUMBER_PER_TICKET) {
            throw new RuntimeException("잘못된 로또 번호 목록입니다.");
        }
    }

    public int compare(WinNumbers winNumbers) {
        return (int) numbers.stream().filter(lotteryNumber -> lotteryNumber.isIn(winNumbers)).count();
    }

    public int size() {
        return this.numbers.size();
    }

    @Override
    public String toString() {
        return numbers.toString();
    }

}
