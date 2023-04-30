package domain;

import java.util.List;

public class LottoMachine {

  private final List<LottoTicket> lottoTickets;
  private final RandomNumberStrategy randomNumberStrategy;

  public LottoMachine(RandomNumberStrategy randomNumberStrategy, int money) {
    this.randomNumberStrategy = randomNumberStrategy;
    this.lottoTickets = makeLottoTickets(money);
  }


  private List<LottoTicket> makeLottoTickets(int money) {
    int numberOfTickets = money / LottoTicket.PRICE;
    for (int i = 0; i < numberOfTickets; i++) {
      List<Integer> lottoNumbers = randomNumberStrategy.generate();
      lottoTickets.add(new LottoTicket(lottoNumbers));
    }
    return lottoTickets;
  }


}
