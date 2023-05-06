package lotto.domain;

import java.util.List;

@FunctionalInterface
public interface GenerateLottoNumberStrategy {
    List<Integer> generate();
}
