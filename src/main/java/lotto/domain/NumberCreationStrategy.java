package lotto.domain;

import java.util.List;

public interface NumberCreationStrategy {

    List<List<Integer>> getNumbers();
}
