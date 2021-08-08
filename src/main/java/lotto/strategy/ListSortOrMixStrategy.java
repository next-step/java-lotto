package lotto.strategy;

import lotto.domain.LottoNumber;

import java.util.List;

public interface ListSortOrMixStrategy {
    void sortOrMix(List<LottoNumber> list);
}
