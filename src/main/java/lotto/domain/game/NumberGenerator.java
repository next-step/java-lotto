package lotto.domain.game;

import java.util.List;

public interface NumberGenerator {

    int MIN_NUMBER = 1;
    int MAX_NUMBER = 45;

    List<Integer> shuffleNumbers();

}
