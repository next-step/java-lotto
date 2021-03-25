package lotto.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import lotto.constant.Constant;

public class LottoNumberStore {
  private final List<LottoNumber> baseNumbers;

  public LottoNumberStore() {
    baseNumbers = createBaseNumbers();
  }

  public List<LottoNumber> createBaseNumbers() {
    return IntStream.rangeClosed(Constant.MIN_NUM, Constant.MAX_NUM)
        .mapToObj(LottoNumber::new)
        .collect(Collectors.toList());
  }

  private void shuffleBaseNumbers(List<LottoNumber> basicNumbers) {
    Collections.shuffle(basicNumbers);
  }

  public List<LottoNumber> createLottoNumbers() {
    shuffleBaseNumbers(baseNumbers);

    return baseNumbers.stream().limit(6).sorted().collect(Collectors.toList());
  }
}
