package lotto.step3.domain;

import java.util.stream.Stream;

public enum Rank {

  FIRST(2_000_000_000, 6),
  SECOND(30_000_000  , 5),
  THIRD(1_500_000, 5),
  FORTH(50_000, 4),
  FIFTH(5_000, 3),
  MISS(0, 0);

  private int price;
  private int same;

  Rank(int price, int same) {
    this.price = price;
    this.same = same;
  }

  public int getPrice() {
    return price;
  }

  public int getSame() {
    return same;
  }

  public static Stream<Rank> stream () {
    return Stream.of(FIRST, SECOND, THIRD, FORTH, FIFTH);
  }

  public static Rank valueOf (long same, boolean matchBonus) {
    return stream().filter(rank -> rank.getSame() == same)
                   .filter(rank -> !rank.equals(SECOND) || matchBonus)
                   .findAny().orElse(MISS);
  }
}
