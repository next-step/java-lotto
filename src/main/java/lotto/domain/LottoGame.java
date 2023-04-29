package lotto.domain;

import lotto.domain.dto.LottoTicketsDto;
import lotto.domain.strategy.DefaultRandomStrategy;
import lotto.domain.strategy.RandomStrategy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static lotto.domain.LottoTicket.TICKET_PRICE;

public class LottoGame {
  private final LottoTickets lottoTickets;

  public LottoGame(Money purchaseAmount) {
    this(purchaseAmount, new DefaultRandomStrategy(), Collections.emptyList());
  }

  public LottoGame(Money purchaseAmount, RandomStrategy randomStrategy) {
    this(purchaseAmount, randomStrategy, Collections.emptyList());
  }

  public LottoGame(
      Money purchaseAmount,
      RandomStrategy randomStrategy,
      List<LottoTicket> manualTickets
  ) {
    Money remainingAmount = purchaseAmount.minus(TICKET_PRICE * manualTickets.size());
    List<LottoTicket> combinedTickets = new ArrayList<>();
    combinedTickets.addAll(manualTickets);
    combinedTickets.addAll(issueLottoTickets(remainingAmount, randomStrategy));
    this.lottoTickets = new LottoTickets(combinedTickets);
  }

  public static Builder builder(Money purchaseAmount) {
    return new Builder(purchaseAmount);
  }

  public static class Builder {
    private Money purchaseAmount;
    private RandomStrategy randomStrategy = new DefaultRandomStrategy();
    private List<LottoTicket> manualLottoTickets = Collections.emptyList();

    public Builder(Money purchaseAmount) {
      this.purchaseAmount = purchaseAmount;
    }

    public Builder randomStrategy(RandomStrategy randomStrategy) {
      this.randomStrategy = randomStrategy;
      return this;
    }

    public Builder manualTickets(List<LottoTicket> manualTickets) {
      this.manualLottoTickets = manualTickets;
      return this;
    }

    public LottoGame build() {
      return new LottoGame(purchaseAmount, randomStrategy, manualLottoTickets);
    }
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
