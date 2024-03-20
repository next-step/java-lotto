package lotto.model;

import java.util.List;

@FunctionalInterface
public interface LottoStrategy {
    List<Lotto> execute(int quantity);
}
