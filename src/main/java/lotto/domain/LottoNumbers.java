package lotto.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class LottoNumbers {

  private static final int LOTTO_NUMBER_SIZE = 6;

  private final List<LottoNumber> numbers;

  private LottoNumbers(List<Integer> numbers) {
    validateNumberSize(numbers);
    validateDuplicate(numbers);
    this.numbers = new ArrayList<>();
    numbers.forEach(i -> this.numbers.add(LottoNumber.of(i)));
  }

  public static LottoNumbers of(Integer...numbers) {
    return new LottoNumbers(Arrays.asList(numbers));
  }

  public static LottoNumbers of(List<Integer> numbers) {
    return new LottoNumbers(numbers);
  }

  public int match(LottoNumbers target) {
    int count = 0;
    for (LottoNumber lottoNumber : numbers) {
      count += target.increment(lottoNumber);
    }
    return count;
  }

  private int increment(LottoNumber lottoNumber) {
    if (contains(lottoNumber)) {
      return 1;
    }
    return 0;
  }

  public boolean match(LottoNumber lottoNumber) {
    return numbers.contains(lottoNumber);
  }

  private void validateDuplicate(List<Integer> numbers) {
    if (new HashSet<>(numbers).size() != LOTTO_NUMBER_SIZE) {
      throw new IllegalArgumentException("중복된 숫자가 입력될 수 없습니다.");
    }
  }

  private void validateNumberSize(List<Integer> numbers) {
    if (numbers.size() != LOTTO_NUMBER_SIZE) {
      throw new IllegalArgumentException("로또 번호는 6자리여야 합니다.");
    }
  }

  boolean contains(LottoNumber lottoNumber) {
    return numbers.contains(lottoNumber);
  }

  @Override
  public String toString() {
    return numbers.toString();
  }
}
