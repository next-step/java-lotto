package lotto.domain.machine;

import java.util.List;

@FunctionalInterface
public interface LottoGenerator {

    List<Integer> get();
}
