package step3.domain;

import java.util.stream.Stream;

public enum WinningPrice {

  FIRST(2000000000, 6),
  SECOND(1500000, 5),
  THIRD(50000, 4),
  FORTH(5000, 3);

  private int price;
  private int same;

  WinningPrice (int price, int same) {
    this.price = price;
    this.same = same;
  }

  public int getPrice() {
    return price;
  }

  public int getSame() {
    return same;
  }

  public static Stream<WinningPrice> stream () {
    return Stream.of(FORTH, THIRD, SECOND, FIRST);
  }
}
