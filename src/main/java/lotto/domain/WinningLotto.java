package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class WinningLotto {

  private List<Integer> numbers = new ArrayList<>();

  public WinningLotto(List<Integer> numbers) {
    this.numbers = numbers;
  }

  public List<Integer> getNumbers() {
    return numbers;
  }

  public int matchingWinningNumber(Lotto lotto) {
    return (int) lotto.getLottoNumbers().stream().filter(numbers::contains).count();

  }
}
