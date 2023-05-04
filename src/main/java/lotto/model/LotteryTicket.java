package lotto.model;

import lotto.util.RandomNumberGenerator;

import java.util.ArrayList;
import java.util.List;

public class LotteryTicket {

    private static final int NUMBER_PER_TICKET = 6;

    private List<LotteryNumber> numbers;

    public LotteryTicket() {
        List<LotteryNumber> numbers = new ArrayList<>();
        for (int i = 0; i < NUMBER_PER_TICKET; i++) {
            numbers.add(new LotteryNumber(new RandomNumberGenerator()));
        }
        this.numbers = numbers;
    }

    public LotteryTicket(List<LotteryNumber> numbers) {
        if (numbers.size() < NUMBER_PER_TICKET) {
            throw new RuntimeException("잘못된 로또 번호 목록입니다.");
        }
        this.numbers = numbers;
    }

    public int compare(List<Integer> winNumbers) {
        return 0;
    }

    public int size() {
        return this.numbers.size();
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
