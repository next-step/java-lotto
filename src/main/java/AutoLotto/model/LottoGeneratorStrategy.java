package autoLotto.model;

import java.util.List;
import java.util.Set;

@FunctionalInterface
public interface LottoGeneratorStrategy {
    Set<LottoNumber> lottoGenerator(List<Integer> lotto);
}
