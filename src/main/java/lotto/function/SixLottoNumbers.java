package lotto.function;

import lotto.domain.LottoNumber;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SixLottoNumbers implements GenerateNumbers {
  private static final List<LottoNumber> values;

  static {
    values = IntStream.rangeClosed(LottoNumber.MIN, LottoNumber.MAX)
            .mapToObj(LottoNumber::generate)
            .collect(Collectors.toList());
  }

  @Override
  public List<LottoNumber> get() {
    Collections.shuffle(values);
    List<LottoNumber> lottoNumbers = values.subList(0, 6);
    Collections.sort(lottoNumbers, (lotto1, lotto2) -> lotto1.getValue() >= lotto2.getValue() ? 1 : -1);
    return Collections.unmodifiableList(new ArrayList<>(lottoNumbers));
  }
}
