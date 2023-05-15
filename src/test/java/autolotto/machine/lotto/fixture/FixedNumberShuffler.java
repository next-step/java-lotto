package autolotto.machine.lotto.fixture;

import autolotto.machine.lotto.Shuffler;

import java.util.Arrays;
import java.util.List;

public class FixedNumberShuffler implements Shuffler {

    @Override
    public List<Integer> shuffle(List<Integer> originals) {
        return Arrays.asList(1, 2, 3, 4, 5, 6);
    }
}
