package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class Lottos {

  private List<Lotto> tickets = new ArrayList<>();
  public Lottos() { }

  public void add(Lotto lotto) {
    tickets.add(lotto);
  }

  public int size() {
    return tickets.size();
  }
  public void checkResult(List<Integer> winNumbers, int bonusNumber) {
    Lotto winner = new Lotto(winNumbers);
    for (Lotto ticket : tickets) {
      ticket.checkResult(winner, new LottoNumber(bonusNumber));
    }
  }

  public int getCount(LottoResult result) {
    int count = 0;
    for (Lotto ticket : tickets) {
      count = checkResult(result, count, ticket);
    }
    return count;
  }

  private int checkResult(LottoResult result, int count, Lotto ticket) {
    if (result.equals(ticket.getResult())) {
      count++;
    }
    return count;
  }

  public double calculateIncomePercent() {
    long total = getTotalRewardPrice();
    double investment = tickets.size() * 1000 * 1.00;
    return total / investment;
  }

  private long getTotalRewardPrice() {
    long total = 0;
    for (LottoResult value : LottoResult.values()) {
      total = total + value.getRewardPrice(getCount(value));
    }
    return total;
  }

  public List<Lotto> getTickets() {
    return tickets;
  }
}
