package step2.domain;

public class WinningPrice {

  public static final int FIRST = 2000000000;
  public static final int SECOND = 1500000;
  public static final int THIRD = 50000;
  public static final int FORTH = 5000;

  private final int price;
  private final int same;

  private WinningPrice (int price, int same) {
    this.price = price;
    this.same = same;
  }

  public int getPrice () {
    return this.price;
  }

  public int getSame () {
    return this.same;
  }

  public static WinningPrice of (int price, int same) {
    return new WinningPrice(price, same);
  }
}
