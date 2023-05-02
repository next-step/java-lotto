package lotto3.domain;

import java.util.List;

public class LottoTicket {

  public static final int TICKET_PRICE = 1000;
  private final LottoNumbers numbers;

  public LottoTicket(List<Integer> numbers) {
    this.numbers = new LottoNumbers(numbers);
  }

  public List<Integer> getNumbers() {
    return numbers.getNumbers();
  }


  public int matchCount(WinningNumbers winningNumbers) {
    return numbers.countMatch(winningNumbers);
  }

  public boolean contains(int bonusNumber) {
    return numbers.contains(bonusNumber);
  }
}
