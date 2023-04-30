package domain;

import java.util.ArrayList;
import java.util.List;

public class LottoMachine {

  private final List<LottoTicket> lottoTickets;
  private final RandomNumberStrategy randomNumberStrategy;

  public LottoMachine(RandomNumberStrategy randomNumberStrategy, int investMoney) {
    this.randomNumberStrategy = randomNumberStrategy;
    this.lottoTickets = makeLottoTickets(investMoney);
  }


  private List<LottoTicket> makeLottoTickets(int money) {
    int numberOfTickets = money / LottoTicket.PRICE;
    List<LottoTicket> lottoTickets = new ArrayList<>();
    for (int i = 0; i < numberOfTickets; i++) {
      List<Integer> lottoNumbers = randomNumberStrategy.generate();
      lottoTickets.add(new LottoTicket(lottoNumbers));
    }
    return lottoTickets;
  }

  public List<LottoTicket> lottoTickets() {
    return lottoTickets;
  }


}
