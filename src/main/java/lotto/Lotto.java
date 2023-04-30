package lotto;

public class Lotto {

  public static final int LOTTO_PRICE = 1000;

  public static int buy(int purchaseAmount) {
    if (purchaseAmount < 1000) {
      throw new IllegalArgumentException();
    }
    purchaseAmount /= LOTTO_PRICE;

    return purchaseAmount;
  }
}
