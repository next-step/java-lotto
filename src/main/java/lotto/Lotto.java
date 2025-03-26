package lotto;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.joining;

public class Lotto {
  public static final int SIZE = 6;
  static final int PRICE = 1000;

  private final List<LottoNumber> numbers;

  public Lotto(List<LottoNumber> numbers) {
    validate(numbers);
    this.numbers = numbers;
  }

  public Lotto(String numbers) {
    List<LottoNumber> lottoNumbers = Arrays.stream(numbers.split(","))
            .map(String::trim)
            .map(num -> new LottoNumber(Integer.parseInt(num)))
            .collect(Collectors.toList());
    validate(lottoNumbers);
    this.numbers = lottoNumbers;
  }

  private void validate(List<LottoNumber> numbers) {
    if (numbers.size() != SIZE) {
      throw new IllegalArgumentException("로또 번호는 6개여야 합니다.");
    }
    Set<LottoNumber> uniqueNumbers = new HashSet<>(numbers);
    if (uniqueNumbers.size() != SIZE) {
      throw new IllegalArgumentException("로또 번호는 중복되지 않아야 합니다.");
    }
  }

  public int countMatchingNumbers(Lotto winningLotto) {
    return (int) numbers.stream()
            .filter(winningLotto::contains)
            .count();
  }

  private boolean contains(LottoNumber lottoNumber) {
    return numbers.contains(lottoNumber);
  }

  public String getNumberRepresentation() {
    return "[" + numbers.stream()
            .map(LottoNumber::getNumber)
            .map(String::valueOf)
            .collect(joining(", ")) + "]";
  }
}
