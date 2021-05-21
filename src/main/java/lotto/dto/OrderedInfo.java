package lotto.dto;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class OrderedInfo {

  private final List<Integer> purchasedLottoInfos;

  public OrderedInfo(List<Integer> purchasedLottoInfos) {
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
    OrderedInfo that = (OrderedInfo) o;
    return purchasedLottoInfos.equals(that.purchasedLottoInfos);
  }

  @Override
  public int hashCode() {
    return Objects.hash(purchasedLottoInfos);
  }
}
