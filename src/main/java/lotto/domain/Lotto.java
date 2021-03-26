package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import lotto.exception.LottoNumberDuplicationException;

public class Lotto {

  private static final int LOTTO_SIZE = 6;

  private List<Number> numbers;

  public Lotto(List<Number> numbers) {
    updateLotto(numbers);
    validation(numbers);
  }

  public static Lotto generatedLottoNumber() {
    List<Number> numbers = new ArrayList<>();
    for(int i = 0; i < LOTTO_SIZE; i++) {
      numbers.add(Number.generateNumber());
    }
    return new Lotto(numbers);
  }

  private void validation(List<Number> numbers) {
    validateLength(numbers);
    validateDuplicated(numbers);
  }

  private void validateDuplicated(List<Number> numbers) {
    Set<Number> numberSet = new HashSet<>(numbers);

    try {
      hasDuplicatedNumber(numbers, numberSet);
    } catch (LottoNumberDuplicationException e) {
      removeDuplicatedAndUpdate(numberSet);
    }
  }

  private void hasDuplicatedNumber(List<Number> numbers, Set<Number> numberSet) {
    if(numberSet.size() != numbers.size()){
      throw new LottoNumberDuplicationException("로또는 중복 값을 가질 수 없습니다.");
    }
  }

  private void removeDuplicatedAndUpdate(Set<Number> numberSet) {
    while(numberSet.size() < LOTTO_SIZE) {
      numberSet.add(Number.generateNumber());
    }
    updateLotto(new ArrayList<>(numberSet));
  }

  private void updateLotto(List<Number> numbers) {
    Collections.sort(numbers);
    this.numbers = numbers;
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
    return  numbers + "\n";
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
