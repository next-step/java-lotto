package factory;

import domain.Lottery;
import domain.LotteryNumber;
import domain.PositiveNumber;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RandomFactory {
  private static Random random = new Random();

  public static PositiveNumber randomNumber() {
    return PositiveNumber.of(random.nextInt(LotteryNumber.UPPER_BOUND.value()) + LotteryNumber.LOWER_BOUND.value());
  }

  public static List<PositiveNumber> randomNumbers(PositiveNumber size) {
    return IntStream.range(0, size.value())
            .mapToObj(i -> randomNumber())
            .collect(Collectors.toList());
  }
}
