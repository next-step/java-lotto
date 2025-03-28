package lotto.domain;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Lotto {
  private final List<LottoNumber> numbers;
  public static final int SIZE = 6;

  public Lotto(List<LottoNumber> numbers) {
    validateChecks(numbers);

    this.numbers = numbers.stream()
        .sorted((n1, n2) -> Integer.compare(n1.getNumber(), n2.getNumber()))
        .collect(Collectors.toList());
  }

  private void validateChecks(List<LottoNumber> numbers) {
    validateSize(numbers);
    validateDuplication(numbers);
  }

  private void validateSize(List<LottoNumber> numbers) {
    if (numbers.size() != SIZE) {
      throw new IllegalArgumentException("로또 번호는 " + SIZE + "개여야 합니다.");
    }
  }

  private void validateDuplication(List<LottoNumber> numbers) {
    Set<LottoNumber> uniqueNumbers = Set.copyOf(numbers);
    if (uniqueNumbers.size() != numbers.size()) {
      throw new IllegalArgumentException("로또 번호는 중복될 수 없습니다.");
    }
  }

  public static Lotto of(String input) {
    List<LottoNumber> numbers = Arrays.stream(input.split(","))
        .map(String::trim)
        .map(Integer::parseInt)
        .map(LottoNumber::new)
        .collect(Collectors.toList());
    return new Lotto(numbers);
  }

  public static Lotto generateRandomLotto(RandomLottoGenerator lottoGenerator) {
    return lottoGenerator.generate();
  }

  public int size() {
    return numbers.size();
  }

  public List<LottoNumber> getNumbers() {
    return List.copyOf(numbers);
  }

  public boolean contains(LottoNumber number) {
    return numbers.contains(number);
  }

  public long matchCountWith(Lotto comparedLotto) {
    return numbers.stream()
        .filter(comparedLotto::contains)
        .count();
  }
}
