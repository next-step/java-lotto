package autolotto.machine.lotto;

import java.util.List;

public interface Shuffler {
    List<Integer> shuffle(List<Integer> originals);
}
