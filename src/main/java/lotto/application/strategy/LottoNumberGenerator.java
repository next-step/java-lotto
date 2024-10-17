package lotto.application.strategy;

import lotto.domain.Lotto;

import java.util.List;

public interface LottoNumberGenerator {
    List<Lotto> generate(int generateCount);

}
