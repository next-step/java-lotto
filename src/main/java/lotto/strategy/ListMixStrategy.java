package lotto.strategy;

import lotto.domain.LottoNumber;

import java.util.Collections;
import java.util.List;

public class ListMixStrategy implements ListSortOrMixStrategy{
    @Override
    public void sortOrMix(List<LottoNumber> list) {
        Collections.shuffle(list);
    }
}
