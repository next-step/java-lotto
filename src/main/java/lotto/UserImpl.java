package lotto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class UserImpl implements User {

  private final LottoEvent lottoEvent;
  private final List<LottoTicket> lottoTickets;
  private int payedMoney;
  private int money;

  public UserImpl(int money, LottoEvent lottoEvent) {
    this.money = money;
    this.lottoEvent = lottoEvent;
    lottoTickets = new ArrayList<>();
  }

  @Override
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

  @Override
  public List<LottoTicket> getLottoTickets() {
    return lottoTickets;
  }

  @Override
  public List<LottoRank> evaluateLottoTickets() {
    return lottoTickets.stream()
        .map(lottoEvent::getRank)
        .collect(Collectors.toList());
  }

  @Override
  public double calculateProfitRate() {
    int totalWinningAmount = evaluateLottoTickets().stream()
        .mapToInt(LottoRank::getWinningAmount)
        .sum();
    return (double) totalWinningAmount / payedMoney;
  }
}
