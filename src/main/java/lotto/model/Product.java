package lotto.model;

import java.util.List;
import java.util.Objects;
import lotto.enums.ChoiceType;
import lotto.enums.Grade;

public final class Product {

  private final List<LottoNo> lottoNumbers;

  public Product(List<LottoNo> lottoNumbers) {
    this.lottoNumbers = lottoNumbers;
  }

  public int coincideLotto(Grade grade, List<Product> allProducts) {
    int result = 0;
    for (Product product : allProducts) {
      result += increaseProductNumber(grade.getExpectNumber(), product).getIncreaseValue();
    }
    return result;
  }

  private ChoiceType increaseProductNumber(int expect, Product product) {
    int count = 0;
    for (LottoNo winNumber : product.lottoNumbers) {
      count += containsWinnerNumber(
          Integer.parseInt(winNumber.toString())).getIncreaseValue();
    }
    if (expect == count) {
      return ChoiceType.GUESSED;
    }
    return ChoiceType.WRONG;
  }

  private ChoiceType containsWinnerNumber(Integer winNumber) {
    if (this.lottoNumbers.contains(new LottoNo(winNumber))) {
      return ChoiceType.GUESSED;
    }
    return ChoiceType.WRONG;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Product product = (Product) o;
    return Objects.equals(lottoNumbers, product.lottoNumbers);
  }

  @Override
  public int hashCode() {
    return Objects.hash(lottoNumbers);
  }

  @Override
  public String toString() {
    return lottoNumbers.toString();
  }
}