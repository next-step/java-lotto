package domain;


import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class LottoBalls implements Iterable<LottoBall> {
  private final List<LottoBall> balls;

  public static LottoBalls of(final LottoBall... balls) {
    return new LottoBalls(List.of(balls));
  }

  public static LottoBalls of(final List<LottoBall> balls) {
    return new LottoBalls(balls);
  }

  public static LottoBalls of(final int... balls) {
    return new LottoBalls(Arrays.stream(balls)
            .mapToObj(LottoBall::of)
            .collect(Collectors.toList()));
  }

  private LottoBalls(final List<LottoBall> balls) {
    this.balls = balls;
  }

  public boolean sizeOf(final PositiveNumber size) {
    return size.equals(this.balls.size());
  }

  public PositiveNumber size() {
    return PositiveNumber.of(this.balls.size());
  }

  public Boolean match(final PositiveNumber index, final LottoBalls target) {
    return this.balls.get(index.value()).equals(target.balls.get(index.value()));
  }

  @Override
  public Iterator<LottoBall> iterator() {
    return new LottoBallsIterator();
  }

  private class LottoBallsIterator implements Iterator<LottoBall> {
    private int cursor = 0;

    @Override
    public boolean hasNext() {
      return cursor < balls.size();
    }

    @Override
    public LottoBall next() {;
      return balls.get(cursor++);
    }
  }

  @Override
  public String toString() {
    return "LottoBalls{" +
            "balls=" + this.balls + '\'' +
            "}";
  }
}
