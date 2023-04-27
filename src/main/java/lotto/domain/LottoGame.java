package lotto.domain;

import lotto.domain.dto.LottoTicketsDto;
import lotto.domain.strategy.DefaultRandomStrategy;
import lotto.domain.strategy.RandomStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LottoGame {
  private final LottoTickets lottoTickets;

  public LottoGame(PurchaseAmount purchaseAmount) {
    this(purchaseAmount, new DefaultRandomStrategy());
  }

  public LottoGame(PurchaseAmount purchaseAmount, RandomStrategy randomStrategy) {
    this.lottoTickets = new LottoTickets(issueLottoTickets(purchaseAmount, randomStrategy));
  }

  private static List<LottoTicket> issueLottoTickets(PurchaseAmount purchaseAmount, RandomStrategy randomStrategy) {
    List<LottoTicket> lottoTicket = new ArrayList<>();
    for (int i = 0; i < purchaseAmount.getTicketCount(); i++) {
      lottoTicket.add(new LottoTicket(new LottoNumbers(randomStrategy.getRandomNumbers()
                                                                     .stream()
                                                                     .map(LottoNumber::new)
                                                                     .collect(Collectors.toList()))));
    }
    return lottoTicket;
  }

  public LottoStatistics getStatistics(LottoNumbers winningNumbers) {
    return lottoTickets.getStatistics(winningNumbers);
  }

  public LottoTicketsDto getLottoTickets() {
    List<List<Integer>> ticketNumbers = lottoTickets.getLottoTickets().stream()
                                                    .map(LottoTicket::getLottoNumbers)
                                                    .map(lottoNumbers -> lottoNumbers.getNumbers()
                                                                                     .stream()
                                                                                     .map(LottoNumber::getNumber)
                                                                                     .collect(Collectors.toList())
                                                    )
                                                    .collect(Collectors.toList());
    return new LottoTicketsDto(ticketNumbers);
  }
}
