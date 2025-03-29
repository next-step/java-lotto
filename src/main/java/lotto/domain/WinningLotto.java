package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class WinningLotto {

  private List<Integer> numbers = new ArrayList<>();

  public WinningLotto(List<Integer> numbers) {
    this.numbers = numbers;
  }

  public int matchingWinningNumber(Lotto lotto) {
    return lotto.findCount(numbers);
  }
}
