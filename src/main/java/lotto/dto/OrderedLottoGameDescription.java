package lotto.dto;

import lotto.domain.LottoGame;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class OrderedLottoGameDescription {

  private final List<Integer> purchasedLottoInfos;
  private final String orderType;

  public OrderedLottoGameDescription(LottoGame lottoGame) {
    this.purchasedLottoInfos = lottoGame.getGameNumbers();
    this.orderType = lottoGame.getOrderTypeName();
  }

  public String getOrderType() {
    return orderType;
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
    OrderedLottoGameDescription that = (OrderedLottoGameDescription) o;
    return purchasedLottoInfos.equals(that.purchasedLottoInfos);
  }

  @Override
  public int hashCode() {
    return Objects.hash(purchasedLottoInfos);
  }
}
