package domain.lotto;

import domain.lotto.vo.LottoNumber;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {

  private final Set<LottoNumber> numbers;

  public Lotto(List<LottoNumber> numbers) {
    this.numbers = new HashSet<>(numbers);
    validateNumberLength();
  }

  public Set<LottoNumber> getNumbers() {
    return numbers;
  }

  private void validateNumberLength(){
    if(this.numbers.size() != 6){
      throw new IllegalArgumentException("로또 번호는 6개여야 합니다.");
    }
  }

}
