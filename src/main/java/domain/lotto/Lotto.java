package domain.lotto;

import domain.lotto.vo.LottoNumber;
import java.util.List;
import java.util.stream.Collectors;

public class Lotto {

  private final List<LottoNumber> numbers;

  public Lotto(List<Integer> numbers) {
    this.numbers = numbers.stream().map(LottoNumber::new).collect(Collectors.toList());
  }

  public List<LottoNumber> getNumbers() {
    return numbers;
  }

}
