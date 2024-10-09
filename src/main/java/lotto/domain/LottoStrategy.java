package lotto.domain;

import java.util.List;

public interface LottoStrategy {
    Lotto getLotto(List<Integer> allList, int count);
}
