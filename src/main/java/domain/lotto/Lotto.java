package domain.lotto;

import domain.lotto.vo.LottoNumber;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Lotto {

  private final Set<LottoNumber> numbers;

  public Lotto(List<Integer> numbers) {
    this.numbers = numbers.stream().map(LottoNumber::of).collect(Collectors.toSet());
  }

  public Set<LottoNumber> getNumbers() {
    return numbers;
  }

}
