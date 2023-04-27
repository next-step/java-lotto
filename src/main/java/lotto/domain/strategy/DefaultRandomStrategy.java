package lotto.domain.strategy;

import lotto.domain.LottoNumbers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DefaultRandomStrategy implements RandomStrategy {
  @Override
  public List<Integer> getRandomNumbers() {
    Collections.shuffle(LottoNumbers.POSSIBLE_NUMBER_RANGE);
    return new ArrayList<>(LottoNumbers.POSSIBLE_NUMBER_RANGE.subList(0, 6));
  }
}
