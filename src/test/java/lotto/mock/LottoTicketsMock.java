package lotto.mock;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import lotto.collections.LottoTickets;
import lotto.collections.WinningNumbers;
import lotto.collections.LottoResult;

public class LottoTicketsMock extends LottoTickets {

  List<LottoTicketMock> lottoTicketMockList;

  public LottoTicketsMock(List<LottoTicketMock> lottoTicketMockList) {
    super();
    this.lottoTicketMockList = lottoTicketMockList;
  }

  @Override
  public LottoResult createLottoResult(WinningNumbers numbers) {
    Map<Integer, Integer> lottoStatistics = this.lottoTicketMockList.stream()
        .map(ticket -> ticket.getMatchCounts(numbers))
        .collect(Collectors
            .groupingBy(Function.identity(), Collectors.reducing(0, e -> 1, Integer::sum)));

    return new LottoResult(lottoStatistics);
  }
}
