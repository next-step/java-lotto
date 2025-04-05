package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lotto {

  private static final int LOTTO_SIZE = 6;
  private static final int MIN_NUMBER = 1;
  private static final int MAX_NUMBER = 45;
  private final List<Integer> numbers;

  public Lotto() {
    this.numbers = createLottoNumbers();
  }

  public Lotto(List<Integer> numbers) {
    this.numbers = numbers;
    validate();
  }

  private void validate() {
    if (numbers.size() != LOTTO_SIZE) {
      throw new IllegalArgumentException("숫자의 개수는 " + LOTTO_SIZE + "개여야 합니다.");
    }
    if (numbers.stream().anyMatch(number -> number < MIN_NUMBER || number > MAX_NUMBER)) {
      throw new IllegalArgumentException("로또 번호는 " + MIN_NUMBER + "부터 " + MAX_NUMBER + " 사이의 숫자여야 합니다.");
    }
  }

  private List<Integer> createLottoNumbers() {
    List<Integer> candidates = new ArrayList<>();
    for (int i = MIN_NUMBER; i <= MAX_NUMBER; i++) {
      candidates.add(i);
    }
    Collections.shuffle(candidates);
    List<Integer> selectedNumbers = candidates.subList(0, LOTTO_SIZE);
    Collections.sort(selectedNumbers);
    return selectedNumbers;
  }

  public int countMatchingNumbers(Lotto other) {
    return (int) numbers.stream()
        .filter(other.numbers::contains)
        .count();
  }

  @Override
  public String toString() {
    return numbers.toString();
  }
}
