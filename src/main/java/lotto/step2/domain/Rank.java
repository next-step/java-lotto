package lotto.step2.domain;

import java.util.stream.Stream;

public enum Rank {

  FIRST(2_000_000_000, 6),
  SECOND(1_500_000, 5),
  THIRD(50_000, 4),
  FORTH(5_000, 3),
  MISS(0, 0);

  private long price;
  private long same;

  Rank(long price, long same) {
    this.price = price;
    this.same = same;
  }

  public long getPrice() {
    return price;
  }

  public long getSame() { return same; }

  public boolean equalSame(long same) { return this.same == same; }

  public static Stream<Rank> stream () {
    return Stream.of(FORTH, THIRD, SECOND, FIRST);
  }

  public static Rank valueOf (long same) {
    return stream().filter(rank -> rank.equalSame(same))
                   .findFirst()
                   .orElse(MISS);
  }
}
