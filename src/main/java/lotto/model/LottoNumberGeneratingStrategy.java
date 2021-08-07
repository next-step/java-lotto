package lotto.model;

import java.util.List;

@FunctionalInterface
public interface LottoNumberGeneratingStrategy {
    List<LottoNumber> generateNumbers();
}
