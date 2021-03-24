package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class Lottos {

  private List<Lotto> tickets = new ArrayList<>();
  private Lotto winner;

  public Lottos() { }

  public void add(Lotto lotto) {
    tickets.add(lotto);
  }

  public int size() {
    return tickets.size();
  }
  public void assignWinNumber(List<Integer> winNumbers) {
    this.winner = new Lotto(winNumbers);
  }

  public void checkResult() {
    for (Lotto ticket : tickets) {
      ticket.checkResult(winner);
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
    long first = LottoResult.FIRST.getRewardPrice(getCount(LottoResult.FIRST));
    long second = LottoResult.SECOND.getRewardPrice(getCount(LottoResult.SECOND));
    long third = LottoResult.THIRD.getRewardPrice(getCount(LottoResult.THIRD));
    long fourth = LottoResult.FOURTH.getRewardPrice(getCount(LottoResult.FOURTH));
    long total = first + second + third + fourth;

    double investment = tickets.size() * 1000 * 1.00;
    return total / investment;
  }

  public List<Lotto> getTickets() {
    return tickets;
  }
}
