package lotto.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LottoRewords {

  private final List<LottoReword> values;

  private LottoRewords(List<LottoReword> values) {
    this.values = values;
  }

  public static LottoRewords from(List<LottoReword> values) {
    return new LottoRewords(values);
  }


  public LottoRewords getRewords(LottoReword targetReword) {
    List<LottoReword> targetRewords = values.stream()
        .filter(lottoReword -> lottoReword.equals(targetReword))
        .collect(Collectors.toList());

    return new LottoRewords(targetRewords);
  }

  public long getRewordSum() {
    return values.stream().mapToLong(lottoReword -> lottoReword.getMoney()).sum();
  }

  public int getSize() {
    return values.size();
  }
}
