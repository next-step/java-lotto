package factory;

import domain.Lotteries;
import domain.Lottery;
import domain.LotteryNumber;
import domain.PositiveNumber;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LotteryFactory {
  public static Lottery randomLottery() {
    List<LotteryNumber> lotteryNumbers = RandomFactory.randomNumbers(Lottery.NUMBER_COUNT)
            .stream()
            .map(LotteryNumber::new)
            .collect(Collectors.toList());

    return Lottery.of(lotteryNumbers);
  }

  public static Lotteries randomLotteries(PositiveNumber size) {
    return new Lotteries(IntStream.range(0, size.value())
            .mapToObj(i -> randomLottery())
            .collect(Collectors.toList()));
  }
}
