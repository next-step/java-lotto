package lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class Lotto {
  static final int PRICE = 1000;
  public static final int SIZE = 6;
  protected final List<LottoNumber> numbers;
  private final LottoType type;

  public Lotto(List<LottoNumber> numbers) {
    this(numbers, LottoType.AUTO);
  }

  public Lotto(List<LottoNumber> numbers, LottoType type) {
    validate(numbers);
    this.numbers = sort(numbers);
    this.type = type;
  }

  private void validate(List<LottoNumber> numbers) {
    if (numbers.size() != SIZE) {
      throw new IllegalArgumentException("로또 번호는 " + Lotto.SIZE + "개여야 합니다.");
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

  public int countMatchingNumbers(Lotto other) {
    return (int) numbers.stream()
            .filter(other::contains)
            .count();
  }

  public String getNumberRepresentation() {
    return "[" + numbers.stream()
            .map(LottoNumber::getNumber)
            .map(String::valueOf)
            .collect(joining(", ")) + "]";
  }

  public boolean isManual() {
    return type == LottoType.MANUAL;
  }

  public boolean isAuto() {
    return type == LottoType.AUTO;
  }
}
