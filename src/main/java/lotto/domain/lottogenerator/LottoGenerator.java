package lotto.domain.lottogenerator;

import java.util.Set;

@FunctionalInterface
public interface LottoGenerator {

    Set<Integer> generateLotto();
}
