package lotto.numberdrawer;

import java.util.List;

public interface NumberDrawer {
    List<Integer> drawnNumbers(int bound, int size);
}
