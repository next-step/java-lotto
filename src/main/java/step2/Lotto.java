package step2;

import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

public final class Lotto implements Iterable<Integer> {

  public static final int FIXED_COUNT = 6;
  protected List<Integer> numbers;

  public Lotto(List<Integer> numbers) {
    validateLength(numbers);
    validateRange(numbers);
    validateDuplicate(numbers);
    Collections.sort(numbers);
    this.numbers = numbers;
  }

  private void validateLength(List<Integer> numbers) {
    if (numbers.size() != FIXED_COUNT) {
      throw new IllegalArgumentException("로또번호는 6개입니다.");
    }
  }

  private void validateRange(List<Integer> numbers) {
    if (isLottoRange(numbers)) {
      throw new IllegalArgumentException("로또번호는 1부터 45번까지입니다.");
    }
  }

  private boolean isLottoRange(List<Integer> numbers) {
    return numbers.stream().anyMatch(n -> n < 0 || n > 45);
  }

  private void validateDuplicate(List<Integer> numbers) {
    HashSet<Integer> sets = new HashSet(numbers);
    if (numbers.size() != sets.size()) {
      throw new IllegalArgumentException("로또번호에 중복값을 있어요.");
    }
  }

  public boolean hasNumber(Integer number) {
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

  @Override
  public Iterator<Integer> iterator() {
    return new Iterator<Integer>() {
      int current = 0;

      @Override
      public boolean hasNext() {
        return current < numbers.size();
      }

      @Override
      public Integer next() {
        return numbers.get(current++);
      }
    };
  }
}
