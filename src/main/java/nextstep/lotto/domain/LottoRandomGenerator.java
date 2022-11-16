package nextstep.lotto.domain;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.function.Supplier;

public class LottoRandomGenerator implements Supplier<Lotto> {

  private final List<LottoNumber> lottoNumbers = LottoNumber.lottoNumbers();

  @Override
  public Lotto get() {
    Collections.shuffle(lottoNumbers);
    return new Lotto(new HashSet<>(lottoNumbers.subList(0, 6)));
  }
}
