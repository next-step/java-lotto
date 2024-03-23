package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RandomShuffle {

    public List<Integer> of(DefaultNumbers defaultNumbers) {
        List<Integer> shuffleNumbers = new ArrayList<>(defaultNumbers.of());
        Collections.shuffle(shuffleNumbers);
        return shuffleNumbers.subList(0, 6);
    }
}
