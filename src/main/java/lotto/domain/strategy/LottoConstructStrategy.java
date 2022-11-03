package lotto.domain.strategy;

import lotto.domain.Lotto;

import java.util.List;

public interface LottoConstructStrategy {
    int LOTTO_COUNT = 6;
    List<Lotto> create(int count);
}
