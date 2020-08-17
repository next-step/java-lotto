package strategy;

import java.util.List;

@FunctionalInterface
public interface LottoNumberGenerator {
    List<Integer> generator();
}
