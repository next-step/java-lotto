package lotto.dto;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class OrderedLottoGameNumbers {

  private final List<Integer> purchasedLottoInfos;

  public OrderedLottoGameNumbers(List<Integer> purchasedLottoInfos) {
    this.purchasedLottoInfos = purchasedLottoInfos;
  }

  @Override
  public String toString() {
    return purchasedLottoInfos.stream()
            .map(String::valueOf)
            .collect(Collectors.joining(", "));
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    OrderedLottoGameNumbers that = (OrderedLottoGameNumbers) o;
    return purchasedLottoInfos.equals(that.purchasedLottoInfos);
  }

  @Override
  public int hashCode() {
    return Objects.hash(purchasedLottoInfos);
  }
}
