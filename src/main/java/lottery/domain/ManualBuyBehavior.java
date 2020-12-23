package lottery.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ManualBuyBehavior implements BuyBehavior {

    @Override
    public List<LotteryNumber> getLotteryNumbers() {
        return null;
    }

    @Override
    public List<LotteryNumber> getLotteryNumbersBy(String numbers) {
        return Arrays.stream(numbers
                .replace(" ", "")
                .split(","))
                .map(Integer::new)
                .map(s -> lotteryAllNumbers.get(s - 1))
                .collect(Collectors.toList());
    }
}
