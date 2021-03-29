package step2.domain;

import step2.domain.number.Number;
import step2.domain.number.Numbers;

public class Lotto {
  private final Numbers numbers;

  public Lotto(Numbers numbers) {
    this.numbers = numbers;
  }

  @Override
  public String toString() {
    return numbers.toString();
  }

  public Number matchLotto(Lotto prizeLotto){
    return numbers.matchNumbers(prizeLotto.numbers);
  }
}
