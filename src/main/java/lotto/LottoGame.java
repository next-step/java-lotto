package lotto;

import lotto.dto.LottoTicketsDto;
import lotto.policy.LottoNumberGeneratePolicy;

import java.util.*;

public class LottoGame {
  private final LottoNumberGeneratePolicy numberGeneratePolicy;
  private final LottoTickets lottoTickets;

  public LottoGame(PurchaseAmount purchaseAmount, LottoNumberGeneratePolicy numberGeneratePolicy) {
    this.numberGeneratePolicy = numberGeneratePolicy;
    this.lottoTickets = new LottoTickets(generateTickets(purchaseAmount.getTicketCount()));
  }

  private List<LottoTicket> generateTickets(int ticketCount) {
    List<LottoTicket> generatedTickets = new ArrayList<>();
    for (int i = 0; i < ticketCount; i++) {
      List<Integer> numbers = numberGeneratePolicy.generateNumbers();
      generatedTickets.add(new LottoTicket(numbers));
    }
    return generatedTickets;
  }

  public LottoTicketsDto getLottoTickets() {
    return new LottoTicketsDto(lottoTickets);
  }

  public LottoStatistics getLottoStatistics(LottoTicket winningNumbers) {
    return new LottoStatistics(lottoTickets, winningNumbers);
  }
}
