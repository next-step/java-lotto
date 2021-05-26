package lotto.dto;

import lotto.domain.LottoGame;

import java.util.List;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;

public class TotalOrderedLottoGameDescription {

  private static final String LINE_FORMAT = "[%s]";
  private static final String ORDER_COUNT_FORMAT = "%s으로 %d장";

  private final List<OrderedLottoGameDescription> infos;
  public TotalOrderedLottoGameDescription(List<LottoGame> games) {
    this.infos = games.stream()
                  .map(OrderedLottoGameDescription::new)
                  .collect(Collectors.toList());
  }

  public String getOrderedCountPerOrderType() {
    return infos.stream()
        .map(OrderedLottoGameDescription::getOrderType)
        .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
        .entrySet()
        .stream()
        .map(entry -> String.format(ORDER_COUNT_FORMAT, entry.getKey(), entry.getValue()))
        .collect(Collectors.joining(", "));

  }

  @Override
  public String toString() {
    return infos.stream()
            .map(info -> String.format(LINE_FORMAT, info.toString()))
            .collect(Collectors.joining(System.lineSeparator()));
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    TotalOrderedLottoGameDescription that = (TotalOrderedLottoGameDescription) o;
    return infos.equals(that.infos);
  }

  @Override
  public int hashCode() {
    return Objects.hash(infos);
  }
}
