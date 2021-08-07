package lotto.strategy;

import java.util.Comparator;
import java.util.List;

public class ListSortStrategy implements ListSortOrMixStrategy{
    @Override
    public void sortOrMix(List<Integer> list) {
        list.sort(Comparator.naturalOrder());
    }
}
