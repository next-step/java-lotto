package autolotto;

import java.util.ArrayList;
import java.util.List;

public class OriginalOrderShuffler implements Shuffler {

    @Override
    public List<Integer> shuffle(List<Integer> originals) {
        return new ArrayList<>(originals);
    }
}
