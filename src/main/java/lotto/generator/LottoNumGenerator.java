package lotto.generator;

import lotto.property.LottoProperty;
import lotto.type.LottoNumList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public interface LottoNumGenerator {
  List<Integer> shuffle(List<Integer> candidates);

  default LottoNumList generate() {
    List<Integer> res = shuffle(getCandidateNumbers()).subList(0, LottoProperty.LOTTO_NUM_SIZE);
    Collections.sort(res);
    return new LottoNumList(res);
  }

  private List<Integer> getCandidateNumbers() {
    List<Integer> numbers = new ArrayList<>();

    for (int i = 1; i <= LottoProperty.LOTTO_CANDIDATE_SIZE; i++) {
      numbers.add(i);
    }

    return numbers;
  }
}
