package lotto;

import java.util.List;
import java.util.Objects;

public final class Product {

  private final List<Integer> lottoNumbers;

  public Product(List<Integer> lottoNumbers) {
    this.lottoNumbers = lottoNumbers;
  }

  public List<Integer> getLottoNumbers() {
    return lottoNumbers;
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
