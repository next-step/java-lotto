package step2;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;

public class Lotto {

  private List<Integer> numbers;

  public Lotto(List<Integer> numbers) {
    validateLength(numbers);
    validateDuplicate(numbers);
    this.numbers = numbers;
  }

  private void validateLength(List<Integer> numbers) {
    if (numbers.size() != 6) {
      throw new IllegalArgumentException("로또번호는 6개입니다.");
    }
  }

  private void validateDuplicate(List<Integer> numbers) {
    HashSet<Integer> sets = new HashSet(numbers);
    if (numbers.size() != sets.size()) {
      throw new IllegalArgumentException("로또번호에 중복값을 있어요.");
    }
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Lotto lotto = (Lotto) o;
    return numbers.equals(lotto.numbers);
  }

  @Override
  public int hashCode() {
    return Objects.hash(numbers);
  }
}
