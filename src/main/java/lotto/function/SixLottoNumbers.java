package lotto.function;

import lotto.domain.LottoNumber;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static lotto.constants.BaseConstants.LOTTO_NUMBER_GREATER_THAN_OR_EQUALS;
import static lotto.constants.BaseConstants.LOTTO_NUMBER_LESS_THAN_OR_EQUALS;

public class SixLottoNumbers implements GenerateNumbers {
  private static final List<LottoNumber> totalLottoNumbers;

  static {
    totalLottoNumbers = IntStream.rangeClosed(LOTTO_NUMBER_GREATER_THAN_OR_EQUALS, LOTTO_NUMBER_LESS_THAN_OR_EQUALS)
            .mapToObj(LottoNumber::generate)
            .collect(Collectors.toList());
  }

  @Override
  public List<LottoNumber> get() {
    Collections.shuffle(totalLottoNumbers);
    List<LottoNumber> lottoNumbers = totalLottoNumbers.subList(0, 6);
    Collections.sort(lottoNumbers, (lotto1, lotto2) -> lotto1.getValue() >= lotto2.getValue() ? 1 : -1);
    return Collections.unmodifiableList(new ArrayList<>(lottoNumbers));
  }
}
