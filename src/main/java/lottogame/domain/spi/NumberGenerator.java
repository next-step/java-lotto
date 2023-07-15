package lottogame.domain.spi;

import java.util.Set;

public interface NumberGenerator {

    Set<Integer> generateDistinctNumbers(int count);
}
