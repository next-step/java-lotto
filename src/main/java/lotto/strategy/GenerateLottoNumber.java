package lotto.strategy;

import java.util.List;
import lotto.domain.LottoNumber;

public interface GenerateLottoNumber {
  List<LottoNumber> createNumberPull();
}
