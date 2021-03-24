package lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {

  private Set<LottoNumber> ticket;
  private LottoResult result;

  public Lotto(List<Integer> numbers) {
    this(createLotto(numbers));
  }

  private static Set<LottoNumber> createLotto(List<Integer> numbers) {
    Set<LottoNumber> ticket = new HashSet<>();
    for (Integer number : numbers) {
      ticket.add(new LottoNumber(number));
    }
    return ticket;
  }

  public Lotto(Set<LottoNumber> ticket) {
    this.ticket = ticket;
    if (ticket.size() != 6) {
      throw new IllegalArgumentException("size is not 6");
    }
  }

  public Set<LottoNumber> getTicket() {
    return ticket;
  }

  public void checkResult(Lotto winner) {
    int containsCount = 0;
    for (LottoNumber lottoNumber : ticket) {
      containsCount = checkContains(winner, containsCount, lottoNumber);
    }
    this.result = LottoResult.findResult(containsCount);
  }

  private int checkContains(Lotto winner, int cotainsCount, LottoNumber lottoNumber) {
    if (winner.ticket.contains(lottoNumber)) {
      cotainsCount++;
    }
    return cotainsCount;
  }

  public LottoResult getResult() {
    return result;
  }

}
