package lotto.numberdrawer;

import java.util.List;

@FunctionalInterface
public interface NumberDrawer {
    List<Integer> drawnNumbers(int bound, int size);
}
