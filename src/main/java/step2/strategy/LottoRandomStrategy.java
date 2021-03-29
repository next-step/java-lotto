package step2.strategy;

import step2.domain.number.Number;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoRandomStrategy implements LottoStrategy {
  private static final int LOTTO_LENGTH = 6;
  private static final int FIRST_INDEX = 0;

  public LottoRandomStrategy() {

  }

  @Override
  public List<Number> markingNumbers(List<Number> lottoNumbers) {
    List<Number> pickedNumbers = new ArrayList<>();
    List<Number> shuffleNumbers = new ArrayList<>(lottoNumbers);
    for (int i = 0; i < LOTTO_LENGTH; i++) {
      Collections.shuffle(shuffleNumbers);
      Number targetNumber = shuffleNumbers.get(FIRST_INDEX);
      pickedNumbers.add(targetNumber);
      shuffleNumbers.remove(targetNumber);
    }
    return pickedNumbers;
  }
}
