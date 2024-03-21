package autoLotto.model;

import java.util.List;

@FunctionalInterface
public interface LottoGeneratorStrategy {
    List<Integer> lottoGenerator(List<Integer> lotto);
}
