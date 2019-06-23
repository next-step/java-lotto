package lotto;

import java.util.HashSet;
import java.util.List;

public class LottoTicket {

  public static final int LOTTO_NUMBER_SIZE = 6;
  private final List<Integer> numbers;

  public LottoTicket(List<Integer> numbers) {
    validateNumberSize(numbers);
    if (new HashSet<>(numbers).size() != LOTTO_NUMBER_SIZE) {
      throw new IllegalArgumentException("중복된 숫자가 입력될 수 없습니다.");
    }
    this.numbers = numbers;
  }

  private void validateNumberSize(List<Integer> numbers) {
    if (numbers.size() != LOTTO_NUMBER_SIZE) {
      throw new IllegalArgumentException("로또 번호는 6자리여야 합니다.");
    }
  }
}
