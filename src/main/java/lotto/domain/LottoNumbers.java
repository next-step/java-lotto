package lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class LottoNumbers {
  public static final int SIZE = 6;
  private final List<LottoNumber> numbers;

  public LottoNumbers(List<LottoNumber> numbers) {
    validate(numbers);
    this.numbers = sort(numbers);
  }

  private void validate(List<LottoNumber> numbers) {
    if (numbers.size() != SIZE) {
      throw new IllegalArgumentException("로또 번호는 " + LottoNumbers.SIZE + "개여야 합니다.");
    }

    Set<LottoNumber> uniqueNumbers = new HashSet<>(numbers);
    if (uniqueNumbers.size() != SIZE) {
      throw new IllegalArgumentException("로또 번호는 중복되지 않아야 합니다.");
    }
  }

  private List<LottoNumber> sort(List<LottoNumber> numbers) {
    return numbers.stream()
            .sorted()
            .collect(toList());
  }

  public boolean contains(LottoNumber number) {
    return numbers.contains(number);
  }

  public long countMatching(LottoNumbers other) {
    return numbers.stream()
            .filter(other::contains)
            .count();
  }

  public String format() {
    return numbers.stream()
            .map(LottoNumber::getNumber)
            .map(String::valueOf)
            .collect(joining(", "));
  }
}
