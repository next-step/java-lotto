package lotto.domain;

import java.util.List;

@FunctionalInterface
public interface ShuffleStrategy {

    void shuffle(List<LottoNumber> objects);
}
