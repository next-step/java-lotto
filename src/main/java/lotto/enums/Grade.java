package lotto.enums;

import java.util.List;
import lotto.model.Product;

public enum Grade {

  THREE(3, 5_000),
  FOUR(4, 50_000),
  FIVE(5, 1_500_000),
  SIX(6, 2_000_000_000);

  private static final Integer GUESSED = 1;
  private static final Integer WRONG = 0;
  private final int expectNumber;
  private final int awardPrice;


  Grade(int expectNumber, int awardPrice) {
    this.expectNumber = expectNumber;
    this.awardPrice = awardPrice;
  }

  public int getExpectNumber() {
    return expectNumber;
  }

  public int getAwardPrice() {
    return awardPrice;
  }

  public int coincideLotto(List<Product> allProducts, List<Integer> winNumbers) {
    int result = 0;
    for (Product product : allProducts) {
      result += increaseProductNumber(this.expectNumber, product, winNumbers);
    }
    return result;
  }

  public int winningAmount(int count) {
    return this.awardPrice * count;
  }

  private static int increaseProductNumber(int expect, Product product, List<Integer> winNumbers) {
    int count = 0;
    for (Integer winNumber : winNumbers) {
      count += containsWinnerNumber(product, winNumber);
    }
    if (expect == count) {
      return GUESSED;
    }
    return WRONG;
  }

  private static int containsWinnerNumber(Product product, Integer winNumber) {
    if (product.getLottoNumbers().contains(winNumber)) {
      return GUESSED;
    }
    return WRONG;
  }
}
