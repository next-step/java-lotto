package nextstep.lotto;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.function.Supplier;

public class LottoRandomGenerator implements Supplier<Lotto> {

  @Override
  public Lotto get() {
    final List<LottoNumber> lottoNumbers = LottoNumber.lottoNumbers();
    Collections.shuffle(lottoNumbers);
    return new Lotto(new HashSet<>(lottoNumbers.subList(0, 6)));
  }
}
