package lotto.strategy;

import java.util.List;
import lotto.model.LottoNumber;

@FunctionalInterface
public interface LottoNumberGenerateStrategy {

  List<LottoNumber> generate();
}
