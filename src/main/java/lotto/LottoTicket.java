package lotto;

import java.util.List;

public class LottoTicket {

  public LottoTicket(List<Integer> numbers) {
    if (numbers.size() != 6) {
      throw new IllegalArgumentException("로또 번호는 6자리여야 합니다.");
    }
  }
}
