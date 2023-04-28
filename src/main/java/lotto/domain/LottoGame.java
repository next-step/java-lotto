package lotto.domain;

import lotto.domain.dto.LottoTicketsDto;
import lotto.domain.strategy.DefaultRandomStrategy;
import lotto.domain.strategy.RandomStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LottoGame {
  private final LottoTickets lottoTickets;

  public LottoGame(Money purchaseAmount) {
    this(purchaseAmount, new DefaultRandomStrategy());
  }

  public LottoGame(Money purchaseAmount, RandomStrategy randomStrategy) {
    this.lottoTickets = new LottoTickets(issueLottoTickets(purchaseAmount, randomStrategy));
  }

  private static List<LottoTicket> issueLottoTickets(Money purchaseAmount, RandomStrategy randomStrategy) {
    List<LottoTicket> lottoTicket = new ArrayList<>();
    for (int i = 0; i < purchaseAmount.getPurchasableTicketCount(); i++) {
      lottoTicket.add(new LottoTicket(new LottoNumbers(randomStrategy.getRandomNumbers()
                                                                     .stream()
                                                                     .map(LottoNumber::from)
                                                                     .collect(Collectors.toList()))));
    }
    return lottoTicket;
  }

  public LottoStatistics getStatistics(LottoNumbers winningNumbers, LottoNumber bonusNumber) {
    if (winningNumbers.contains(bonusNumber)) {
      throw new IllegalArgumentException("로또 번호는 중복될 수 없습니다.");
    }
    return new LottoStatistics(lottoTickets, winningNumbers, bonusNumber);
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
