package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Lotto {

  private static final int LOTTO_SIZE = 6;
  private final List<LottoNo> numbers;

  public Lotto() {
    this.numbers = createLottoNumbers();
  }

  public Lotto(List<Integer> numbers) {
    this.numbers = numbers.stream()
        .map(LottoNo::of)
        .collect(Collectors.toList());
    validate();
  }

  private void validate() {
    if (numbers.size() != LOTTO_SIZE) {
      throw new IllegalArgumentException("숫자의 개수는 " + LOTTO_SIZE + "개여야 합니다.");
    }
  }

  private List<LottoNo> createLottoNumbers() {
    List<LottoNo> candidates = new ArrayList<>();
    for (int i = LottoNo.MIN_NUMBER; i <= LottoNo.MAX_NUMBER; i++) {
      candidates.add(LottoNo.of(i));
    }
    Collections.shuffle(candidates);
    List<LottoNo> selectedNumbers = candidates.subList(0, LOTTO_SIZE);
    selectedNumbers.sort((a, b) -> a.getNumber() - b.getNumber());
    return selectedNumbers;
  }

  public int countMatchingNumbers(Lotto other) {
    return (int) numbers.stream()
        .filter(other.numbers::contains)
        .count();
  }

  public boolean hasBonusBall(int bonusBall) {
    return numbers.contains(LottoNo.of(bonusBall));
  }

  public String getNumbersAsString() {
    return numbers.stream()
        .map(LottoNo::getNumber)
        .map(String::valueOf)
        .collect(Collectors.joining(", ", "[", "]"));
  }
}
