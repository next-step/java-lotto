package lotto.strategy;

import lotto.domain.Lotto;

import java.util.List;

public interface NumberStrategy {

    List<Lotto> create(int count);
}
