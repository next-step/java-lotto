package lotto;

import java.util.List;

@FunctionalInterface
public interface LottoNumberPickStrategy {
    List<Integer> pickNumbers();
}
