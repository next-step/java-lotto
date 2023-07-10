package lottogame.domain.spi;

import java.util.List;

public interface NumberGenerator {

    List<Integer> generate(int count);
}
