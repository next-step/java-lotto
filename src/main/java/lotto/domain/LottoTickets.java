package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoTickets {

  private final List<Lotto> lottoTickets;

  private LottoTickets(List<Lotto> tickets) {
    this.lottoTickets = new ArrayList<>(Objects.requireNonNull(tickets, "로또 티켓 목록이 null입니다."));
  }

  public static LottoTickets of(int count) {
    List<Lotto> tickets = IntStream.range(0, count)
        .mapToObj(i -> new LottoGenerator().generateAutoLotto())
        .collect(Collectors.toList());
    return new LottoTickets(tickets);
  }

  public static LottoTickets of(List<Lotto> manualLottos, int totalCount) {
    if (manualLottos == null) {
      throw new IllegalArgumentException("수동 로또 목록이 null입니다.");
    }
    int autoCount = totalCount - manualLottos.size();
    validateAutoCount(autoCount);

    List<Lotto> tickets = new ArrayList<>(manualLottos);
    IntStream.range(0, autoCount)
        .forEach(i -> tickets.add(new LottoGenerator().generateAutoLotto()));
    return new LottoTickets(tickets);
  }

  private static void validateAutoCount(int autoCount) {
    if (autoCount < 0) {
      throw new IllegalArgumentException("수동 로또 수가 구매 가능한 로또 수를 초과했습니다.");
    }
  }

  public int size() {
    return lottoTickets.size();
  }

  public LottoStatistics createWinningStatistics(Lotto winningNumbers, int bonusBall) {
    if (winningNumbers == null) {
      throw new IllegalArgumentException("당첨 번호가 null입니다.");
    }
    return new WinningStatisticsCalculator(winningNumbers, bonusBall).calculate(lottoTickets);
  }

  public List<Lotto> getLottoTickets() {
    return Collections.unmodifiableList(lottoTickets);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    LottoTickets that = (LottoTickets) o;
    return lottoTickets.equals(that.lottoTickets);
  }

  @Override
  public int hashCode() {
    return lottoTickets.hashCode();
  }
}
