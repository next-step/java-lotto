package domain;

import java.util.ArrayList;
import java.util.List;

public class LottoMachine {
  private final RandomNumberStrategy randomNumberStrategy;

  public LottoMachine(RandomNumberStrategy randomNumberStrategy) {
    this.randomNumberStrategy = randomNumberStrategy;
  }


  public List<LottoTicket> makeLottoTickets(int investMoney) {
    int numberOfTickets = investMoney / LottoTicket.PRICE;
    List<LottoTicket> lottoTickets = new ArrayList<>();
    for (int i = 0; i < numberOfTickets; i++) {
      List<Integer> lottoNumbers = randomNumberStrategy.generate();
      lottoTickets.add(new LottoTicket(lottoNumbers));
    }
    return lottoTickets;
  }



}
