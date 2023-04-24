package lotto.domain;

import java.util.List;

public interface NumberCreationStrategy {

    int LOTTO_SIZE = 6;

    List<Integer> createNumber();
}
