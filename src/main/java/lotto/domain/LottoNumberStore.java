package lotto.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import lotto.constant.Constant;

public class LottoNumberStore {

  public List<Number> createBaseNumbers() {
    return IntStream.rangeClosed(Constant.MIN_NUM, Constant.MAX_NUM)
        .mapToObj(Number::new)
        .collect(Collectors.toList());
  }

  private void shuffleBaseNumbers(List<Number> basicNumbers) {
    Collections.shuffle(basicNumbers);
  }

  public List<Number> createLottoNumbers() {
    List<Number> baseNumbers = createBaseNumbers();
    shuffleBaseNumbers(baseNumbers);

    return baseNumbers.stream().limit(6).sorted().collect(Collectors.toList());
  }
}
