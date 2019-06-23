package lotto;

public class LottoStore {

  public static int buyLottoCount(String price) {
    return Integer.parseInt(price) / 1000;
  }
}
