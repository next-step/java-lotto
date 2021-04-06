package lotto.function;

import lotto.domain.LottoNumber;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SixLottoNumbers implements GenerateNumbers {
  private static final int LOTTO_NUMBER_GREATER_THAN_OR_EQUALS = 1;
  private static final int LOTTO_NUMBER_LESS_THAN = 45;
  private static List<LottoNumber> sixLottoNumbers;

  static {
    sixLottoNumbers = IntStream.rangeClosed(LOTTO_NUMBER_GREATER_THAN_OR_EQUALS, LOTTO_NUMBER_LESS_THAN)
            .mapToObj(LottoNumber::generate)
            .collect(Collectors.toList());
  }

  @Override
  public List<LottoNumber> get() {
    Collections.shuffle(sixLottoNumbers);
    return sixLottoNumbers.subList(0, 6);
  }
}
