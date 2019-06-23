package lotto;

import java.util.List;

public class LottoTicket {

  public static final int LOTTO_NUMBER_SIZE = 6;
  private final List<Integer> numbers;

  public LottoTicket(List<Integer> numbers) {
    validateNumberSize(numbers);
    this.numbers = numbers;
  }

  private void validateNumberSize(List<Integer> numbers) {
    if (numbers.size() != LOTTO_NUMBER_SIZE) {
      throw new IllegalArgumentException("로또 번호는 6자리여야 합니다.");
    }
  }
}
