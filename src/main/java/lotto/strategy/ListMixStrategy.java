package lotto.strategy;

import lotto.domain.LottoNumber;

import java.util.Collections;
import java.util.List;
import java.util.Random;

public class ListMixStrategy implements ListSortOrMixStrategy{
    @Override
    public void sortOrMix(List<LottoNumber> list) {
        long seed = System.nanoTime();
        Collections.shuffle(list, new Random(seed));
    }
}
