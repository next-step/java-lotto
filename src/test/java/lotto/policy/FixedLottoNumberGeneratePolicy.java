package lotto.policy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FixedLottoNumberGeneratePolicy implements LottoNumberGeneratePolicy {
  private int count = 0;

  @Override
  public List<Integer> generateNumbers() {
    List<Integer> generatedNumbers = new ArrayList<>();
    for (int i = 0; i < 6; i++) {
      generatedNumbers.add(count % 45 + 1);
      count++;
    }
    Collections.reverse(generatedNumbers);
    return generatedNumbers;
  }
}
