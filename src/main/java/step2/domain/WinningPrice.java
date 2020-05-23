package step2.domain;

public class WinningPrice {
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
