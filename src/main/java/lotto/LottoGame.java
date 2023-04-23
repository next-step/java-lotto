package lotto;

import lotto.policy.LottoNumberGeneratePolicy;

import java.util.*;

public class LottoGame {
  private final LottoNumberGeneratePolicy numberGeneratePolicy;
  private final LottoTickets lottoTickets;

  public LottoGame(int purchaseAmount, LottoNumberGeneratePolicy numberGeneratePolicy) {
    this.numberGeneratePolicy = numberGeneratePolicy;
    this.lottoTickets = new LottoTickets(generateTickets(getTicketCount(purchaseAmount)));
  }

  private static int getTicketCount(int purchaseAmount) {
    return purchaseAmount / 1000;
  }

  private List<LottoTicket> generateTickets(int ticketCount) {
    List<LottoTicket> generatedTickets = new ArrayList<>();
    for (int i = 0; i < ticketCount; i++) {
      List<Integer> numbers = numberGeneratePolicy.generateNumbers();
      generatedTickets.add(new LottoTicket(numbers));
    }
    return generatedTickets;
  }

  public LottoTickets getLottoTickets() {
    return lottoTickets;
  }
}
