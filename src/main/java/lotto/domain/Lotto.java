package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import lotto.exception.LottoNumberDuplicationException;
import lotto.util.AutoLottoNumberGenerateStrategy;
import lotto.util.LottoNumberGenerator;
import lotto.util.ManualLottoNumberGenerateStrategy;

public class Lotto {

  private static final int LOTTO_SIZE = 6;

  private final List<Number> numbers;

  public Lotto(List<Number> numbers) {
    validation(numbers);
    this.numbers = numbers;
  }

  public static Lotto createAutoLotto() {
    return new Lotto(LottoNumberGenerator
        .createAutoLottoNumbers(new AutoLottoNumberGenerateStrategy()));
  }

  public static Lotto createManualLotto(List<Integer> inputNumbers) {
    return new Lotto(LottoNumberGenerator
        .createManualLottoNumbers(new ManualLottoNumberGenerateStrategy(inputNumbers)));
  }

  private void validation(List<Number> numbers) {
    validateLength(numbers);
    validateDuplicated(numbers);
  }

  private void validateDuplicated(List<Number> numbers) {
    if(isDuplicatedNumber(numbers)) {
      throw new LottoNumberDuplicationException("로또는 중복 값을 가질 수 없습니다.");
    }
  }

  private boolean isDuplicatedNumber(List<Number> numbers) {
    return numbers.stream()
        .distinct()
        .count() != numbers.size();
  }

  private void validateLength(List<Number> numbers) {
    if(numbers.size() < LOTTO_SIZE) {
      throw new IllegalArgumentException("로또 숫자는 6개여야 합니다.");
    }
  }

  public List<Number> getNumbers() {
    return new ArrayList<>(numbers);
  }

  @Override
  public String toString() {
    List<Number> numbers = getNumbers();
    return numbers.stream()
        .map(Number::toString)
        .collect(Collectors.joining(", "));
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Lotto)) {
      return false;
    }
    Lotto lotto = (Lotto) o;
    return Objects.equals(numbers, lotto.numbers);
  }

  @Override
  public int hashCode() {
    return Objects.hash(numbers);
  }
}
