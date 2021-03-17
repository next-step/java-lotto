package lottery.dto;

import lottery.domain.Lottery;

import java.util.Collections;
import java.util.List;

public class LotteryProxy implements ReadonlyLottery {

    private final Lottery lottery;

    public LotteryProxy(Lottery lottery) {
        this.lottery = lottery;
    }

    @Override
    public List<Integer> getNumbers() {
        return Collections.unmodifiableList(lottery.getNumbers());
    }

}
