package lotto.domain.strategy;

import java.util.List;

@FunctionalInterface
public interface GenerateNumbersStrategy {

  List<Integer> generate();
}
