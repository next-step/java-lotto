package lotto.generator;

import lotto.property.LottoProperty;
import lotto.type.LottoNumList;

import java.util.ArrayList;
import java.util.List;

public interface LottoNumGenerator {
  List<Integer> shuffle(List<Integer> candidates);

  default LottoNumList generate() {
    return new LottoNumList(shuffle(getCandidateNumbers()).subList(0, LottoProperty.LOTTO_NUM_SIZE));
  }

  private List<Integer> getCandidateNumbers() {
    List<Integer> numbers = new ArrayList<>();

    for (int i = 1; i <= LottoProperty.LOTTO_NUM_SIZE; i++) {
      numbers.add(i);
    }

    return numbers;
  }
}
