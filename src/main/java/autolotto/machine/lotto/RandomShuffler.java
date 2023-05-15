package autolotto.machine.lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RandomShuffler implements Shuffler {

    @Override
    public List<Integer> shuffle(List<Integer> originals) {

        ArrayList<Integer> copy = new ArrayList<>(originals);
        Collections.shuffle(copy);

        return copy;
    }
}
