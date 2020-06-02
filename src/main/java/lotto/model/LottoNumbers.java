package lotto.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class LottoNumbers {

  private final List<Integer> numbers;

  public LottoNumbers(List<Integer> numbers) {
    checkLottoNumberSize(numbers);
    checkLottoNumberRange(numbers);
    checkLottoNumberDuplicated(numbers);

    numbers.sort(Integer::compareTo);

    this.numbers = new ArrayList<>(numbers);
  }

  public List<Integer> values() {
    return new ArrayList<>(numbers);
  }

  private void checkLottoNumberSize(List<Integer> numbers) {
    if (numbers.size() != Lotto.SIZE) {
      throw new IllegalArgumentException("로또 숫자는 6개가 입력되어야 합니다. " + numbers);
    }
  }

  private void checkLottoNumberRange(List<Integer> numberList) {
    if (!LottoNumberPool.INSTANCE.getNumbers().containsAll(numberList)) {
      throw new IllegalArgumentException("로또 숫자는 1~45 사이로 입력되어야 합니다.");
    }
  }

  private void checkLottoNumberDuplicated(List<Integer> numbers) {
    if (new HashSet<>(numbers).size() != Lotto.SIZE) {
      throw new IllegalArgumentException("로또 숫자는 중복되면 안됩니다.");
    }
  }
}
