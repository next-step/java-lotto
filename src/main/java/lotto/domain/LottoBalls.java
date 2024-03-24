package lotto.domain;


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

  public boolean sizeOf(final int size) {
    return this.balls.size() == size;
  }

  public int size() {
    return this.balls.size();
  }

  public LottoBall ballAt(final int index) {
    return this.balls.get(index);
  }

  public Boolean matchBallAt(int index, LottoBall ball) {
    return this.balls.get(index).equals(ball);
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
    public LottoBall next() {
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
