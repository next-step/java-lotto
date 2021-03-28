package lotto.util;

import java.util.List;
import lotto.domain.Number;

@FunctionalInterface
public interface  LottoNumberGenerateStrategy {
  List<Number> generate();
}
