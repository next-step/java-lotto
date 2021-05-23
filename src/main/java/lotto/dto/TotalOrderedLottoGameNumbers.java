package lotto.dto;

import lotto.domain.LottoGame;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class TotalOrderedLottoGameNumbers {

  private static final String LINE_FORMAT = "[%s]";

  private final List<OrderedLottoGameNumbers> infos;
  public TotalOrderedLottoGameNumbers(List<LottoGame> games) {
    this.infos = games.stream()
                  .map(lottoGame -> new OrderedLottoGameNumbers(lottoGame.getGameNumbers()))
                  .collect(Collectors.toList());
  }

  public int getOrderedCount() {
    return infos.size();
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
    TotalOrderedLottoGameNumbers that = (TotalOrderedLottoGameNumbers) o;
    return infos.equals(that.infos);
  }

  @Override
  public int hashCode() {
    return Objects.hash(infos);
  }
}
