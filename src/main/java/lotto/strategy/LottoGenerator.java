package lotto.strategy;

import lotto.domain.Lotto;
import lotto.vo.LottoCreateRequest;

import java.util.List;

@FunctionalInterface
public interface LottoGenerator {
    List<Lotto> generate(final LottoCreateRequest lottoCreateRequest);
}
