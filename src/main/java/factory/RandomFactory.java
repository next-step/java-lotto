package factory;

import domain.LottoBall;
import domain.PositiveNumber;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RandomFactory {
  private static final List<PositiveNumber> cache = IntStream.range(LottoBall.LOWER_BOUND.value(), LottoBall.UPPER_BOUND.value() + 1)
          .mapToObj(PositiveNumber::new)
          .collect(Collectors.toList());

  private final Random random;

  public RandomFactory(Random random) {
    this.random = random;
  }

  public PositiveNumber randomNumber() {
    return cache.get(cacheIndex());
  }

  protected int cacheIndex() {
    return random.nextInt(LottoBall.UPPER_BOUND.value()) + LottoBall.LOWER_BOUND.value() - 1;
  }

  public List<PositiveNumber> randomNumbers(PositiveNumber size) {
    return IntStream.range(0, size.value())
            .mapToObj(i -> randomNumber())
            .collect(Collectors.toList());
  }
}
