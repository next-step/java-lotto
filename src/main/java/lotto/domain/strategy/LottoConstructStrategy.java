package lotto.domain.strategy;

import java.util.List;
import java.util.Set;

public interface LottoConstructStrategy {
    List<Set<Integer>> create(int count);
}
