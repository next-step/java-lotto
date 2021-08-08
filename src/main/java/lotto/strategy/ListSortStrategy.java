package lotto.strategy;

import lotto.domain.LottoNumber;

import java.util.Comparator;
import java.util.List;

public class ListSortStrategy implements ListSortOrMixStrategy{
    @Override
    public void sortOrMix(List<LottoNumber> list) {
        list.sort(new Comparator<LottoNumber>() {
            @Override
            public int compare(LottoNumber o1, LottoNumber o2) {
                if(o1.getLottoNumber() > o2.getLottoNumber())
                    return 1;
                return -1;
            }
        });
    }
}
