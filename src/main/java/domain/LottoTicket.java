package domain;

import java.util.List;

public class LottoTicket {

  public static final int PRICE = 1000;
  private final List<Integer> numbers;

  public LottoTicket(List<Integer> numbers) {
    this.numbers = numbers;
  }

}
