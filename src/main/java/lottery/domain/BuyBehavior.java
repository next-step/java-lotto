package lottery.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public interface BuyBehavior {
    int END_INCLUSIVE = 45;
    int START_INCLUSIVE = 1;
    List<LotteryNumber> lotteryAllNumbers = IntStream.rangeClosed(START_INCLUSIVE, END_INCLUSIVE)
            .boxed()
            .map(LotteryNumber::of)
            .collect(Collectors.toList());

    List<LotteryNumber> getLotteryNumbers();
    List<LotteryNumber> getLotteryNumbersBy(String numbers);
}
