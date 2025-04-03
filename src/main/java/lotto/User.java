package lotto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class User {

  private final LottoEvent lottoEvent;
  private final List<LottoTicket> lottoTickets;
  private int payedMoney;
  private int money;

  public User(int money, LottoEvent lottoEvent) {
    this.money = money;
    this.lottoEvent = lottoEvent;
    lottoTickets = new ArrayList<>();
  }

  public void buyAllLottoTickets() {
    int lottoPrice = lottoEvent.getLottoTicketPrice();
    int lottoCount = money / lottoPrice;
    money -= lottoPrice * lottoCount;
    payedMoney = lottoPrice * lottoCount;
    lottoTickets.addAll(
        IntStream.range(0, lottoCount)
            .mapToObj(i -> lottoEvent.sellAutoLottoTicket())
            .collect(Collectors.toList())
    );
  }

  public List<LottoTicket> getLottoTickets() {
    return lottoTickets;
  }

  public List<LottoRank> evaluateLottoTickets() {
    return lottoTickets.stream()
        .map(lottoEvent::getRank)
        .collect(Collectors.toList());
  }

  public double calculateProfitRate() {
    int totalWinningAmount = evaluateLottoTickets().stream()
        .mapToInt(LottoRank::getWinningAmount)
        .sum();
    return (double) totalWinningAmount / payedMoney;
  }
}
