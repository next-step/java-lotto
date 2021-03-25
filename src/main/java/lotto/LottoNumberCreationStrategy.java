package lotto;

import java.util.List;
import lotto.domain.LottoNumber;

public interface LottoNumberCreationStrategy {

  List<LottoNumber> create();
}
