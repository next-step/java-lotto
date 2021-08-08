package lotto.strategy;

import lotto.domain.LottoNumber;

import java.util.List;

@Deprecated
public interface ListSortOrMixStrategy {
    void sortOrMix(List<LottoNumber> list);
}
