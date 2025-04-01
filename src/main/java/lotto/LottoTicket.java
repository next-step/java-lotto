package lotto;

import java.util.List;

public class LottoTicket {

  private final LottoTicketNumberSet numberSet;

  public LottoTicket(int number1, int number2, int number3, int number4, int number5, int number6) {
    this.numberSet = new LottoTicketNumberSet(
        List.of(
            new LottoTicketNumber(number1),
            new LottoTicketNumber(number2),
            new LottoTicketNumber(number3),
            new LottoTicketNumber(number4),
            new LottoTicketNumber(number5),
            new LottoTicketNumber(number6)
        )
    );
  }

  @Override
  public boolean equals(Object o) {
    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    LottoTicket that = (LottoTicket) o;
    return numberSet.equals(that.numberSet);
  }

  @Override
  public int hashCode() {
    return numberSet.hashCode();
  }

  public int countMatchingNumbers(LottoTicketNumberSet winningNumbers) {
    return (int) numberSet.getNumbers().stream()
        .filter(winningNumbers.getNumbers()::contains)
        .count();
  }

}

