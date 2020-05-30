package lotto.util;

import java.util.List;
import lotto.domain.LottoNumber;

public interface LottoNumberGenerator {

  List<LottoNumber> shuffle();
}
