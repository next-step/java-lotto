package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class Lotto {

  private static final int LOTTO_NUMBER_COUNT = 6;
  private static final int MIN_NUMBER = 1;
  private static final int MAX_NUMBER = 45;
  private List<Integer> lottoNumbers = new ArrayList<>();

  public Lotto(List<Integer> lottoNumbers) {
    validateLottoNumbers(lottoNumbers);
    this.lottoNumbers = lottoNumbers;
  }

  public Lotto(DrawingStrategy drawingStrategy) {
    validateLottoNumbers(drawingStrategy.draw());
    this.lottoNumbers = drawingStrategy.draw();
  }

  private void validateLottoNumbers(List<Integer> numbers) {
    if (numbers.size() != LOTTO_NUMBER_COUNT) {
      throw new IllegalArgumentException();
    }
    if (numbers.stream().anyMatch(num -> num < MIN_NUMBER || num > MAX_NUMBER)) {
      throw new IllegalArgumentException();
    }
  }

  public int findCount(List<Integer> numbers) {
    return (int) lottoNumbers
        .stream()
        .filter(numbers::contains)
        .count();
  }

  public List<Integer> getLottoNumbers() {
    return lottoNumbers;
  }
}
