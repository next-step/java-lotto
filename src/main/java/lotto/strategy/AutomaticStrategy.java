package lotto.strategy;

import java.util.List;

public interface AutomaticStrategy {

    int SIZE = 6;

    List<Integer> choose(List<Integer> numbers);
}
