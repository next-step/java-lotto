package lottery;

import java.util.Arrays;
import java.util.stream.Collectors;

public class TestLotteryFactory {

    static Lottery createLottery(Integer... values) {
        return new Lottery(Arrays.stream(values).map(LotteryNumber::new).collect(Collectors.toList()));
    }

}
