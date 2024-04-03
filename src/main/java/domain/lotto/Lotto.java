package domain.lotto;

import domain.lotto.vo.LottoNumber;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {

  private final Set<LottoNumber> numbers;

  public Lotto(List<LottoNumber> numbers) {
    validateNumberLength(numbers.size());
    this.numbers = new HashSet<>(numbers);
  }

  public Set<LottoNumber> getNumbers() {
    return numbers;
  }

  private void validateNumberLength(Integer numberLength){
    if(numberLength != 6){
      throw new IllegalArgumentException("로또 번호는 6개여야 합니다.");
    }
  }

}
