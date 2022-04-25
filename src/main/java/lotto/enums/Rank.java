package lotto.enums;

import java.util.List;
import lotto.LottoConfirm;
import lotto.Product;

public enum Rank {
  THREE(3, 5_000),
  FOUR(4, 50_000),
  FIX(5, 1_500_000),
  SIX(6, 2_000_000_000);

  private final int expectNumber;
  private final int awardPrice;

  Rank(int expectNumber, int awardPrice) {
    this.expectNumber = expectNumber;
    this.awardPrice = awardPrice;
  }

  public int coincideLotto(List<Product> allProducts, List<Integer> winNumbers) {
    int result = 0;
    for (Product product : allProducts) {
      result += LottoConfirm.increaseProductNumber(this.expectNumber,  product, winNumbers);
    }
    return result;
  }

  public int winningAmount(int count) {
    return this.awardPrice * count;
  }
}
