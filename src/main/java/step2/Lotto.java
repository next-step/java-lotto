package step2;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;

public class Lotto {

  public static final int FIXED_COUNT = 6;
  protected List<Integer> numbers;

  public Lotto(List<Integer> numbers) {
    validateLength(numbers);
    validateDuplicate(numbers);
    Collections.sort(numbers);
    this.numbers = numbers;
  }

  private void validateLength(List<Integer> numbers) {
    if (numbers.size() != FIXED_COUNT) {
      throw new IllegalArgumentException("로또번호는 6개입니다.");
    }
  }

  private void validateDuplicate(List<Integer> numbers) {
    HashSet<Integer> sets = new HashSet(numbers);
    if (numbers.size() != sets.size()) {
      throw new IllegalArgumentException("로또번호에 중복값을 있어요.");
    }
  }

  protected boolean hasNumber(Integer number) {
    return numbers.contains(number);
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

  @Override
  public String toString() {
    return "[" + numbers + ']';
  }
}
