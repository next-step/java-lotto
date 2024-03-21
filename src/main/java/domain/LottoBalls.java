package domain;


import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoBalls {
  private final List<LottoBall> balls;

  public LottoBalls(final List<LottoBall> balls) {
    this.balls = balls;
  }

  public static LottoBalls of(final LottoBall... balls) {
    return new LottoBalls(List.of(balls));
  }

  public static LottoBalls of(final int... balls) {
    return new LottoBalls(Arrays.stream(balls)
            .mapToObj(LottoBall::of)
            .collect(Collectors.toList()));
  }

  public PositiveNumber matchCount(final LottoBalls comparison) {
    int count = IntStream.range(0, this.balls.size())
            .reduce(0, (acc, cur) -> {
              if (this.balls.get(cur).equals(comparison.balls.get(cur))) {
                return ++acc;
              }
              return acc;
            });
    return PositiveNumber.of(count);
  }

  public boolean sizeOf(final PositiveNumber size) {
    return size.equals(this.balls.size());
  }

  @Override
  public String toString() {
    final String OPENER = "[";
    final String CLOSER = "]";
    final String CONNECTOR = ", ";

    StringBuilder sb = new StringBuilder(OPENER);
    for (LottoBall ball : this.balls) {
      sb.append(ball).append(CONNECTOR);
    }

    final int STARTING_INDEX = 0;
    return sb.substring(STARTING_INDEX, sb.length() - CONNECTOR.length()).concat(CLOSER);
  }
}