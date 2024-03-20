package autoLotto.model;

import java.util.List;

@FunctionalInterface
public interface LottoGeneratorStrategy {
    int[] lottoGenerator(List<Integer> lotto);
}
