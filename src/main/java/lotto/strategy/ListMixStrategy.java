package lotto.strategy;

import java.util.Collections;
import java.util.List;
import java.util.Random;

public class ListMixStrategy implements ListSortOrMixStrategy{
    @Override
    public void sortOrMix(List<Integer> list) {
        long seed = System.nanoTime();
        Collections.shuffle(list, new Random(seed));
    }
}
