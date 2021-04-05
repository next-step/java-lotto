package lotto.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoNumbers {
  private final List<LottoNumber> lottoNumbers;

  private LottoNumbers(List<LottoNumber> lottoNumbers) {
    this.lottoNumbers = Collections.unmodifiableList(lottoNumbers);
  }

  public static LottoNumbers generateSixNumbers() {
    List<LottoNumber> sixLottoNumbers = IntStream.range(0, 6)
            .mapToObj(index -> LottoNumber.generate())
            .collect(Collectors.toList());
    return new LottoNumbers(sixLottoNumbers);
  }

  public int size() {
    return lottoNumbers.size();
  }

  public List<LottoNumber> getLottoNumbers() {
    return lottoNumbers;
  }
}
