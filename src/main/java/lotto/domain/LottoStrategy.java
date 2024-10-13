package lotto.domain;

import java.util.List;

public interface LottoStrategy {
    Lotto getLotto(List<LottoNum> allList, int count);
}
