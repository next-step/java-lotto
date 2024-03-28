package domain.lotto;

import domain.lotto.vo.LottoNumber;
import java.util.List;
import java.util.stream.Collectors;

public class Lotto {

  private final List<Integer> numbers;

  public Lotto(List<Integer> numbers) {
    this.numbers = numbers;
  }

  public List<Integer> getNumbers() {
    return numbers;
  }

}
