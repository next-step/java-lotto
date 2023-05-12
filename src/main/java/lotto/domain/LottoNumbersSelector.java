package lotto.domain;

import java.util.List;

public interface LottoNumbersSelector {
  List<LottoNumber> selectBy(int number);
}
