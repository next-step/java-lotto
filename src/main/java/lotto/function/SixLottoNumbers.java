package lotto.function;

import lotto.domain.LottoNumber;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SixLottoNumbers implements GenerateNumbers {
  private static final int LOTTO_NUMBER_GREATER_THAN_OR_EQUALS = 1;
  private static final int LOTTO_NUMBER_LESS_THAN = 46;

  @Override
  public List<LottoNumber> get() {
    List<LottoNumber> sixLottoNumbers = IntStream.range(LOTTO_NUMBER_GREATER_THAN_OR_EQUALS, LOTTO_NUMBER_LESS_THAN)
            .mapToObj(LottoNumber::generate)
            .collect(Collectors.toList());

    Collections.shuffle(sixLottoNumbers);
    return sixLottoNumbers.subList(0, 6);
  }
}
