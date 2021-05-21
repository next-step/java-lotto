package lotto.domain;

import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class LottoNumbers {

  static final int NUMBER_COUNT_PER_GAME = 6;
  private static final String INVALID_NUMBER_COUNT_FORMAT = "로또 번호 개수는 %d개 여야 합니다.";

  private final Set<LottoNumber> numbers;

  public LottoNumbers(List<LottoNumber> lottoNumbers) {
    this.numbers = toSet(lottoNumbers);
  }

  public List<Integer> numbers() {
    return numbers.stream()
            .map(LottoNumber::number)
            .collect(Collectors.toList());
  }

  public int match(LottoNumbers gameNumbers) {
    return (int) numbers.stream()
        .filter(gameNumbers.numbers::contains)
        .count();
  }

  private Set<LottoNumber> toSet(List<LottoNumber> lottoNumbers) {
    Set<LottoNumber> uniqueNumbers = new TreeSet<>(lottoNumbers);
    if(uniqueNumbers.size() != NUMBER_COUNT_PER_GAME) {
      throw new IllegalArgumentException(String.format(INVALID_NUMBER_COUNT_FORMAT, NUMBER_COUNT_PER_GAME));
    }
    return uniqueNumbers;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    LottoNumbers that = (LottoNumbers) o;
    return numbers.equals(that.numbers);
  }

  @Override
  public int hashCode() {
    return Objects.hash(numbers);
  }
}
