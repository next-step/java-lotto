package lotto.model;

import java.util.List;

public final class LottoConfirm {

  private static final Integer GUESSED = 1;
  private static final Integer WRONG = 0;

  public static int increaseProductNumber(int expect, Product product, List<Integer> winNumbers) {
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
