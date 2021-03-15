package lottery.dto;

import java.util.Collections;
import java.util.List;

public class LotteryProxy implements ReadonlyLottery {

    private final List<Integer> numbers;

    public LotteryProxy(ReadonlyLottery readonlyLottery) {
        numbers = Collections.unmodifiableList(readonlyLottery.getNumbers());
    }

    @Override
    public List<Integer> getNumbers() {
        return numbers;
    }

}
